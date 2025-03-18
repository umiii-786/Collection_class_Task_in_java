class Stack {
    private int arr[] = new int[5];
    private int pointer = 0;

    // method which push the element
    void push(int val) {
        if (pointer==arr.length) {
            System.out.println("StackOverflow error ouccered ");
            return;
        }
        arr[pointer] = val;
        ++pointer;
    }

    // method which return the top most element of stack
    int peek() {
        if (pointer==0) {
            System.out.print("having no any element in list");
            return -1;
        }
        return arr[pointer - 1];
    }

    // method which remove and return the top most element of stack 
    int pop() {
        if (pointer==0) {
            System.out.print("underflow error ouccered with value ");
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



    // check wheather stack is empty or not 
    boolean IsEmpty() {
        if (pointer == 0)
            return false;
        else
            return true;
    }
    // check wheather stack is Full or not 
    boolean IsFull() {
        if (pointer == 9)
            return true;
        else
            return false;
    }
    // print the Stack element
    void printStack() {
        System.out.print("[");
        for (int i = 0; i <pointer; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.print("]");
        System.out.println("\n");
    }

}
public class Array_Implementation {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(0);
        st.push(65);
        st.printStack();

        System.out.println(st.pop());
        System.out.println(st.peek());
    }
}







        // Scanner sc=new Scanner(System.in);

        // while (true) {
        //     System.out.println(" \'Enter the 1 for pushing value in Stack enter 2 for pop value from stack and enter 3 for display the stack value or for break enter 4 :\'");
        //     int des=sc.nextInt();
        //     System.out.println("\n");
        //     if (des==4) {
        //         break;
        //     }
        //     else if (des==1) {
        //         System.out.println("enter the value :");
        //         st.push(sc.nextInt());
        //     }
        //     else if (des==2) {
        //        System.out.println("the value at top is :"+st.pop()); 
        //     }
        //     else if (des==3) {
        //         st.printStack();
        //     }
         
            
        // }
        
        // st.push(11);
        // st.push(15);
        // st.push(8);
        // st.push(1);
        // st.push(16);
        // st.printStack();
        // System.out.println(st.pop());
        // st.printStack();
        // System.out.println(st.peek());
        // System.out.println(st.pop());
        // st.printStack();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.printStack();
        
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
        // st.pop();
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
