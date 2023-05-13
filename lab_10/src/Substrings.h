#include <iostream>
#include <string>
#include <iterator>

using namespace std;

class Substrings {
public:
    Substrings(const string& str) : str_(str) {}

    class Iterator : public iterator<forward_iterator_tag, string> {
    public:
        unsigned int start_pos = 0;
        string substring;

        Iterator(const string& str, unsigned int pos) : str_(str), start_pos(pos) {
            while (start_pos < str_.length() && !isVowel(str_[start_pos])) {
                start_pos++;
            }
            if (start_pos == str_.length()) {
                start_pos = 0;
                substring = "";
            }
            else {
                unsigned int end_pos = start_pos + 1;
                while (end_pos < str_.length() && isVowel(str_[end_pos])) {
                    end_pos++;
                }
                substring = str_.substr(start_pos, end_pos - start_pos);
                start_pos = end_pos;
            }
        }

        bool operator==(const Iterator& other) const {
            return start_pos == other.start_pos && substring == other.substring;
        }

        bool operator!=(const Iterator& other) const {
            return !(*this == other);
        }

        Iterator& operator++() {
            while (start_pos < str_.length() && !isVowel(str_[start_pos])) {
                start_pos++;
            }
            if (start_pos == str_.length()) {
                start_pos = 0;
                substring = "";
            }
            else {
                unsigned int end_pos = start_pos + 1;
                while (end_pos < str_.length() && isVowel(str_[end_pos])) {
                    end_pos++;
                }
                substring = str_.substr(start_pos, end_pos - start_pos);
                start_pos = end_pos;
            }
            return *this;
        }

        Iterator operator++(int) {
            Iterator temp = *this;
            ++(*this);
            return temp;
        }

        const string& operator*() const {
            return substring;
        }

    private:
        const string str_;

        bool isVowel(char c) const {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }

    };

    Iterator begin() const {
        return Iterator(str_, 0);
    }

    Iterator end() const {
        return Iterator(str_, str_.length());
    }

private:
    const string str_;
};