#include <iostream>
using namespace std;
class Stack {
private:
    int arr[5];
    int pointer;

public:
    Stack() : pointer(0) {}

    // Method which pushes the element
    void push(int val) {
        if (pointer == 5) {
            cout << "StackOverflow error occurred\n";
            return;
        }
        arr[pointer] = val;
        ++pointer;
    }
    // Method which returns the topmost element of stack
    int peek() {
        if (pointer == 0) {
            cout << "Having no any element in list\n";
            return -1;
        }
        return arr[pointer - 1];
    }

    // Method which removes and returns the topmost element of stack 
    int pop() {
        if (pointer == 0) {
            cout << "Underflow error occurred with value\n";
            return -1;
        }
        int val = arr[pointer - 1];
        --pointer;
        return val;
    }

    // Return the Size of Stack
    int size() {
        return pointer;
    }

    // Check whether stack is empty or not 
    bool IsEmpty() {
        return pointer == 0;
    }

    // Check whether stack is full or not 
    bool IsFull() {
        return pointer == 5;
    }

    // Print the Stack elements
    void printStack() {
        cout << "[";
        for (int i = 0; i < pointer; i++) {
            cout << arr[i] << ", ";
        }
        cout << "]\n\n";
    }
};

int main() {
    Stack st;
    st.push(0);
    st.push(65);
    st.printStack();

    cout << st.pop() << endl;
    cout << st.peek() << endl;

    return 0;
}
