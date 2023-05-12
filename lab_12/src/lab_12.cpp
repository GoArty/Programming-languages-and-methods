#include <iostream>
#include <cstring>
#include <sys/types.h>
#include <dirent.h>
#include <fstream>

using namespace std;

int main(int argc, char *argv[])
{
    if (argc != 2) {
        cout << "Usage: " << argv[0] << " directoryPath" << endl;
        return 1;
    }

    DIR *dir = opendir(argv[1]);
    if (dir == NULL)
    {
        cout << "Failed to open directory!" << endl;
        return 1;
    }

    struct dirent *ent;
    char path[1000], outfilename[1000], buffer[1024];
    ifstream infile;
    ofstream outfile;

    while ((ent = readdir(dir)) != NULL)
    {
        if (ent->d_type == DT_REG && strstr(ent->d_name, ".html"))
        {
            cout << "Processing file " << ent->d_name << "..." << endl;

            strcpy(path, argv[1]);
            strcat(path, "/");
            strcat(path, ent->d_name);

            infile.open(path);
            if (!infile.is_open())
            {
                cout << "Failed to open input file!" << endl;
                return 1;
            }

            strcpy(outfilename, ent->d_name);
            outfile.open(outfilename);
            if (!outfile.is_open())
            {
                cout << "Failed to open output file!" << endl;
                return 1;
            }

            bool in_script = false;
            while(infile.getline(buffer, 1024))
            {
                char *pos = buffer;
                while (*pos)
                {
                    if (in_script)
                    {
                        if (strncmp(pos, "</script>", 9) == 0)
                        {
                            pos += 9;
                            in_script = false;
                        }
                        else
                        {
                            ++pos;
                        }
                    }
                    else
                    {
                        char *start = strstr(pos, "<script>");
                        if (start)
                        {
                            outfile.write(pos, start-pos);
                            pos = start;
                            in_script = true;
                        }
                        else
                        {
                            outfile << *pos;
                            if(*pos++ =='>' ){
                            	outfile << endl;
                            }
                        }
                    }
                }

                if (in_script)
                {
                    outfile << endl;
                }
            }

            infile.close();
            outfile.close();
        }
    }

    closedir(dir);
    return 0;
}
