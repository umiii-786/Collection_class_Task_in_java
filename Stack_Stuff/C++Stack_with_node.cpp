#include <iostream>
using namespace std;

class Node {
public:
    int val;
    Node* next;

    Node(int val) : val(val), next(nullptr) {}
};

class Stack {
private:
    Node* head;
    int size;

public:
    Stack() : head(nullptr), size(0) {}

    void push(int val) {
        Node* newnode = new Node(val);
        newnode->next = head;
        head = newnode;
        size++;
    }

    int pop() {
        if (head == nullptr) {
            cout << "Stack is empty\n";
            return -1;
        }
        int val = head->val;
        Node* temp = head;
        head = head->next;
        delete temp;
        size--;
        return val;
    }

    int peek() {
        if (head == nullptr) {
            cout << "Stack is empty\n";
            return -1;
        }
        return head->val;
    }
    int getSize() {
        return size;
    }
    void displayrec(Node* head) {
        if (head == nullptr)
            return;

        int val = head->val;
        displayrec(head->next);
        cout << val << " ,";
    }
    void display() {
        displayrec(head);
        cout << endl;
    }
    ~Stack() {
        while (head != nullptr) {
            Node* temp = head;
            head = head->next;
            delete temp;
        }
    }
};

int main() {
    Stack st;
    st.push(5);
    st.push(8);
    st.push(11);

    st.display();
}
    st.pop();
    st.display();

    return 0;
}
