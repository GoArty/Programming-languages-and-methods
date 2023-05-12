#include <iostream>
#include <set>
#include "Set.h"
using namespace std;
int main() {
    Set<char> set1;
    set1 &= 'a';
    set1 &= 'b';
    set1 &= 'c';

    Set<char> set2;
    set2 &= 'd';
    set2 &= 's';
    set2 &= 'c';

    cout << "Set1: ";
    for (auto letter : set1) {
        cout << letter << " ";
    }
    cout << endl;

    cout << "Set2: ";
    for (auto letter : set2) {
        cout << letter << " ";
    }
    cout << endl;

    Set<char> set4;
    set4 &= 'j';
    set4 &= 'k';
    set4 &= 'l';

    cout << "Set4: ";
    for (auto letter : set4) {
        cout << letter << " ";
    }
    cout << endl;
    
    (!set4);
    
    cout << "!Set4: ";
    for (auto letter : set4) {
        cout << letter << " ";
    }
    cout << endl;
    
    (!set4);
    cout << "!(!Set4): ";
    for (auto letter : set4) {
        cout << letter << " ";
    }
    cout << endl;

    Set<char> set5; 
    set5 &= set1; 
    set5 &= set2; 

    cout << "Set5: ";
    for (auto letter : set5) {
        cout << letter << " ";
    }
    cout << std::endl;

    cout << "Set1 == Set2: " << (set1 == set2) << endl;
    cout << "Set1 != Set2: " << (set1 != set2) << endl;

    return 0;
}
