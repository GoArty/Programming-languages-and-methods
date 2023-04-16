#include <iostream>
#include "TicTacToeBoard.h"
using namespace std;

int main() {
    int n = 3;
    TicTacToeBoard board(n);
    board.getCell(0, 0) = 'X';
    board.getCell(0, 0) = 'O';
    board.getCell(1, 1) = 'O';
    board.getCell(0, 2) = 'O';
    board.getCell(2, 2) = 'X';
    cout << "Size: " << board.getSize() << endl;
    cout << "Cell (0, 0): " << board.getCell(0, 0) << endl;
    cout << "Cell (1, 1): " << board.getCell(1, 1) << endl;
    cout << "Is final position: " << board.isFinalPosition() << endl;
    return 0;
}
