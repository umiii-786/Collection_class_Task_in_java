public class Circular_Q_By_LL {
    Node head;
    Node tail;
    class Node{
        int data;
        Node next;
        Node(int d){
            data=d;
            next=null;
        }
    }
    public void add(int v){
        Node newnode=new Node(v);
        if (head==null) {
            head=newnode;
            tail=head;
            return;
        }
        tail.next=newnode;
        tail=newnode;
        tail.next=head;
    }
    public int pop(){
        int val=head.data;
        head=head.next;
        return -1;
    }

    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"  ,");
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        Circular_Q_By_LL oj=new Circular_Q_By_LL();
        oj.add(454);
        oj.add(22);
        oj.display();
    }
}
