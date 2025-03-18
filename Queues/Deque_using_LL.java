class Node  {
    int data;
    Node next;
    Node previous;

    Node(int d){
        data=d;
        next=null;
        previous=null;
    }
}

public class Deque_using_LL {
    Node head;
    Node tail;
    public void addFirst(int data){
        Node newnode=new Node(data);
        if (head==null) {
            head=newnode;
            tail=newnode;
            return;
        }
        newnode.next=head;
        head.previous=newnode;
        head=newnode;
    }
    public void addLast(int v){
        Node newnode=new Node(v);
        if (head==null) {
            head=newnode;
            tail=newnode;
            return;
        }
        tail.next=newnode;
        newnode.previous=tail;
        tail=newnode;
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+" , ");
            temp=temp.next;
        }
    }

    public int peekFirst(){
        return head.data;
    }
    public int peekLast(){
        return tail.data;
    }
    public int removeFirst(){
       int val=head.data;
       head=head.next;
       head.previous=null;
        return val;
    }
    public int removeLast(){
       int val=tail.data;
       tail=tail.previous;
       tail.next=null;
        return val;
    }

    public static void main(String[] args) {
        Deque_using_LL d=new Deque_using_LL();
        d.addFirst(334);
        d.addFirst(432);
        d.addFirst(12);
        d.addLast(1);
        d.display();
        d.removeFirst();
        System.out.println("\n");
        d.display();
        d.removeLast();
         System.out.println("\n");
        d.display();

    }
}
