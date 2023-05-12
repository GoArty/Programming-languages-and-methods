template <int L, int R, class T>
class PascalArray {
private:
    T arr[R - L + 1];

public:
    T& operator[](int i) {
        return arr[i - L];
    }

    template <int L2, int R2>
    auto operator+ (PascalArray<L2, R2, T>& other) const {
        static_assert(R == L2 - 1);
        PascalArray<L, R2, T> result;
        for (int i = L; i <= R2; ++i) {
            if (i <= R) {
                result[i] = arr[i - L];
            } else {
                result[i] = other[i];
            }
        }
        return result;
    }
};
