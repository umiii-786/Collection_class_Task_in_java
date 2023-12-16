
class Stack {
    private int arr[] = new int[5];
    private int pointer = 0;

    void push(int val) {
        if (pointer==arr.length) {
            System.out.println("StackOverflow error ouccered ");
            return;
        }
        arr[pointer] = val;
        ++pointer;
    }

    int peek() {
        if (pointer==0) {
            System.out.print("having no any element in list");
            return -1;
        }
        return arr[pointer - 1];
    }

    int pop() {
        if (pointer==0) {
            System.out.print("underflow error ouccered with value ");
            return -1;
        }
        int val = arr[pointer - 1];
        --pointer;
        return val;
    }

    int size() {
        return pointer;
    }

    boolean IsEmpty() {
        if (pointer == 0)
            return false;
        else
            return true;
    }

    boolean IsFull() {
        if (pointer == 9)
            return true;
        else
            return false;
    }

    void printStack() {
        System.out.print("[");
        for (int i = 0; i <pointer; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print("]");
    }

}

public class Array_Implementation {

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(6);
        st.push(11);
        st.push(15);
        st.push(8);
        st.push(1);
        st.push(16);
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        st.printStack();
        // st.push(4);
        // st.push(8);
        // st.pop();
        // st.pop();
        // st.push(8);
        // st.push(3);
        // st.push(11);
        // st.push(12);
        // st.pop();
    // System.out.println(st.peek());
        // st.printStack();
        // System.out.println(st.IsEmpty());
        // System.out.println(st.IsFull());
        // System.out.println(st.peek());
        // st.printStack();
        // System.out.println(st.size());


    }
}
