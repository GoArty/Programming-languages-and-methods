#include<iostream>
#include<cassert>
#include"PascalArray.h"

using namespace std;

void test_index_operator() {
    PascalArray<1, 5, int> p_array;
    p_array[1] = 10;
    p_array[2] = 20;
    assert(p_array[1] == 10);
    assert(p_array[2] == 20);
}

void test_concatenation_operator() {
    PascalArray<1, 5, int> p_array1;
    p_array1[1] = 10;
    p_array1[2] = 20;

    PascalArray<6, 9, int> p_array2;
    p_array2[6] = 30;
    p_array2[7] = 40;
    p_array2[8] = 50;
    p_array2[9] = 60;

    auto p_array3 = p_array1 + p_array2;
    assert(p_array3[1] == 10);
    assert(p_array3[2] == 20);
    assert(p_array3[6] == 30);
    assert(p_array3[7] == 40);
    assert(p_array3[8] == 50);
    assert(p_array3[9] == 60);
}

int main() {
    test_index_operator();
    test_concatenation_operator();

    return 0;
}
