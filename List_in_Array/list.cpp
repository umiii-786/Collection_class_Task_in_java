#include <iostream>
#include <vector>

class Implementing_List {
private:
    std::vector<int> array;
    int current;
    int size;

public:
    Implementing_List() : array(20), current(-1), size(0) {}

    // Incrementing the shift
    void next() {
        if (current == size - 1) {
            std::cout << "Having no any element\n";
            return;
        }
        current++;
    }

    // Printing the list
    void print() {
        std::cout << "[";
        for (int i = 0; i < size; i++) {
            std::cout << array[i] << ",";
        }
        std::cout << "]\n\n";
    }

    // Decrementing the current
    void back() {
        if (current == -1) {
            std::cout << "Not going to previous\n";
            return;
        }
        current--;
    }

    // Adding the element at the current +1 position
    void add(int value) {
        if (current == size - 1) {
            array[current + 1] = value;
            current++;
            size++;
        } else {
            for (int i = size - 1; i > current; i--) {
                array[i + 1] = array[i];
            }
            array[current + 1] = value;
            current++;
            size++;
        }
    }

    // Changing the value on the current position
    void update(int val) {
        array[current] = val;
    }

    // Removing the element at the current position
    void remove() {
        if (current == size - 1) {
            array[current] = 0;
        } else {
            for (int i = current; i < size; i++) {
                array[i] = array[i + 1];
            }
        }
        size--;
    }

    // Pointing the current at the last element
    void End() {
        current = size - 1;
    }

    // Setting the current at -1 position
    void start() {
        current = -1;
    }
};

int main() {
    Implementing_List l;
    l.add(24);
    l.add(67);
    l.add(89);
    l.start();
    l.add(5);

    return 0;
}
