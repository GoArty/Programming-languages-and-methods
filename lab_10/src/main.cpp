#include "Substrings.h"
using namespace std;


int main() {
    Substrings s1("feegeeeozd UAIEOoeegreeju  uqwertyuiopasdfghjklzxcvbnm");
    for (Substrings::Iterator it = s1.begin(); it != s1.end(); ++it) {
        cout << *it << endl;
    }
    cout<<endl;
    Substrings s2("ee eeeo UAIEOoee ee uu e uio a");
    for (Substrings::Iterator it = s2.begin(); it != s2.end(); ++it) {
        cout << *it << endl;
    }
    cout<<endl;
    Substrings s3("dOuBlE fReE ");
    for (Substrings::Iterator it = s3.begin(); it != s3.end(); ++it) {
        cout << *it << endl;
    }
    return 0;
}