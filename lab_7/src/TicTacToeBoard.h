class TicTacToeBoard {
private:
    char **board;
    int size;
public:
    TicTacToeBoard(int n) {
        size = n;
        board = new char*[size];
        for (int i = 0; i < size; i++) {
            board[i] = new char[size];
            for (int j = 0; j < size; j++) {
                board[i][j] = '_';
            }
        }
    }

    int getSize() {
        return size;
    }

    char &getCell(int i, int j) {
        return board[i][j];
    }

    bool isFinalPosition() {
        for (int i = 0; i < size; i++) {
            int j = 0;
            while (j < size - 1 && board[i][j] == board[i][j + 1]) {
                j++;
            }
            if (j == size - 1 && board[i][j] != '_') {
                return true;
            }
        }

        for (int j = 0; j < size; j++) {
            int i = 0;
            while (i < size - 1 && board[i][j] == board[i + 1][j]) {
                i++;
            }
            if (i == size - 1 && board[i][j] != '_') {
                return true;
            }
        }

        int i = 0;
        while (i < size - 1 && board[i][i] == board[i + 1][i + 1]) {
            i++;
        }
        if (i == size - 1 && board[i][i] != '_') {
            return true;
        }

        i = 0;
        while (i < size - 1 && board[i][size - i - 1] == board[i + 1][size - i - 2]) {
            i++;
        }
        if (i == size - 1 && board[i][size - i - 1] != '_') {
            return true;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == '_') {
                    return false;
                }
            }
        }
        return true;
    }

    ~TicTacToeBoard() {
        for (int i = 0; i < size; i++) {
            delete[] board[i];
        }
        delete[] board;
    }
};
