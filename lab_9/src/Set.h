#include <set>
#include <algorithm>
using namespace std;
template<typename T>
class Set {
private:
    set<T> data;
public:
    Set() {}

    Set<T>& operator&=(const Set<T>& other) {
        for (const auto& item : other.data) {
            this->data.insert(item);
        }

        for (auto it1 = this->data.begin(); it1 != this->data.end(); ++it1) {
            auto it2 = find_if(it1, this->data.end(), [&](const T& item) {
                return *it1 == !item;
            });
            if (it2 != this->data.end()) {
                this->data.erase(it1);
                this->data.erase(it2);
                break; 
            }
        }

        return *this;
    }

    Set<T>& operator&=(const T& item) {
        this->data.insert(item);

        auto it1 = this->data.find(item);
        if (it1 != this->data.end()) {
            auto it2 = find_if(it1, this->data.end(), [&](const T& item) {
                return *it1 == !item;
            });
            if (it2 != this->data.end()) {
                this->data.erase(it1);
                this->data.erase(it2);
            }
        }

        return *this;
    }

Set<T>& operator!() {
        set<T> new_data;
        for (const auto& item : this->data) {
            new_data.insert(item ^ 15);
        }
        this->data = new_data;
        return *this;
    }

    bool operator==(const Set<T>& other) const {
        return this->data == other.data;
    }
    bool operator!=(const Set<T>& other) const {
        return this->data != other.data;
    }

    typename set<T>::iterator begin() {
        return data.begin();
    }

    typename set<T>::iterator end() {
        return data.end();
    }
};
