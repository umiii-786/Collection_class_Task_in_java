public class Linked_List_implementing {
    Node head;
    Node currNode;
    Node prevNode;
    class Node {
        int data;
        Node next;
        Node(int v){
          this.data=v;
          this.next=null;
        }   
        // void setNext(Node n){
        //     this.next=n;
        // }        
        // Node getnext(){
        //     return this.next;
        // }
        // void setData(int v){
        //     this.data=v;
        // }
        // int getData(){
        //     return this.data;
        // }
    }


    public void add(int v){
        Node newnode=new Node(v);
        if (head==null) {
            head=newnode;
            currNode=newnode;
            return;
        }
        if (currNode==null) {
            currNode=newnode;
            return;
        }
        newnode.next=currNode.next;
        currNode.next=newnode;
        prevNode=currNode;
        currNode=newnode;
    }

    public void remove(){
        if (head==null) {
            System.out.println("list is empty");
            return;
        }
        if (currNode==null) {
            System.out.println("current is pointing at the null");
            return;
        }
        currNode=currNode.next;
        prevNode.next=currNode;
    }
    public void back(){
        Node temp=head;
        while (temp.next!=prevNode && temp!=prevNode) {
            temp=temp.next;
        }
        currNode=prevNode;
        prevNode=temp;
    }
    public int get(){
        if (currNode==null) {
            System.out.print("current is pointing to null");
            return -1;
        }
        return currNode.data;
    }
    public void next(){
        if (currNode==null) {
            System.out.println("currently is already poiting to the null");
            return;
        }
        currNode=currNode.next;
        prevNode=prevNode.next;
    }
    public void display(){
        Node temp=head;
        while (temp!=null) {
            System.out.print(temp.data+"   ,");
            temp=temp.next;
        }
       System.out.println("\n");
    }
    public static void main(String[] args) {
        Linked_List_implementing ll=new Linked_List_implementing();
        ll.add(456);
        ll.add(2323);
        ll.add(7767);
        ll.display();
    
        ll.back();
        ll.back();
     
        ll.add(54678);
        ll.add(232);
        ll.display();

        System.out.println(
            ll.get()
        );
    }
}
