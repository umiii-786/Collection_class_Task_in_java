class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Queues_Implementing_my_LL {
    private Node head;
    private Node tail;
    private int size=0;
    public void push(int val) {
        Node newnode = new Node(val);
        if (head == null) {
            head = newnode;
            tail=newnode;
            System.out.println("null ");
            size++;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " , ");
            temp = temp.next;
        }
    }

    public int pop() {
        if (head == null) {
            return -1;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int peek() {
        if (head == null) {
            return -1;
        }
        return head.data;
    }
    public int size(){
        return size;
    }

    public static void main(String[] args) {
        Queues_Implementing_my_LL l = new Queues_Implementing_my_LL();
        l.push(5);
        l.push(11);
        l.push(12);

        l.display();
        System.out.println("\n");
        System.out.println(l.pop());
        l.display();
        System.out.println("\n");
        System.out.println(l.peek());
        l.display();

    }
}