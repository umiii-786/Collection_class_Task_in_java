class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class Stack {

    Node head = null;
    Node temp = head;
    private int size = 0;

    public void push(int val) {
        Node newnode = new Node(val);
        newnode.next = head;
        head = newnode;
        size++;
    }

    public int pop() {
        if (head == null) {
            System.out.print("stack is empty ");
            return -1;
        }
        int val = head.val;
        head = head.next;
        size--;
        return val;
    }

    public int peek() {
        return head.val;
    }

    public int size() {
        return size;
    }


    public void displayrec(Node head){
        if (head==null) {
            return;
        }

        int val=head.val;
        displayrec(head.next);
        System.out.print(val+" ,");

    }
    public void display() {
        displayrec(head);
    }

}

public class LinkedList_Implementation {
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(5);
        st.push(8);
        st.push(11);


        st.display();
        // st.pop();
        // st.pop();
        // st.pop();

        // st.pop();
        // st.display(st.head);
        // System.out.println("\n");
        // st.pop();
        // st.display(st.head);
        // System.out.println("\n");
        // System.out.println(st.peek());

        // System.out.println(st.size());
    }
}
