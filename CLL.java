class Node{
    
    int val;
    Node next;

    Node (int val){
        this.val=val;
        next=null;
    }
}

public class CLL {
    Node head;
    public void add(int val){
        Node newnode=new Node(val);
       if (head==null) {
        head=newnode;
        return;
       }
       newnode.next=head;
       head=newnode;

    }

    public void printAll(){
        Node temp=this.head;
        while (temp!=null) {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
    }

    public boolean check_circular(Node head){
        Node temp=head.next;
        while (true) {
            if(temp!=head){
            return true;
            }
            temp=temp.next;

        }
    }


    public void printAll_from_random(Node head){
        Node temp=head.next;
        System.out.print(head.val+" ");
        while (temp!=head) {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }

    }
    public static void main(String[] args) {
        CLL list=new CLL();
        list.add(3);
        list.add(5);
        list.add(10);
        list.add(33);

        list.printAll();
        list.head.next.next.next.next=list.head;
        System.out.println(list.check_circular(list.head));
        list.printAll_from_random(list.head.next.next);


    }

}
