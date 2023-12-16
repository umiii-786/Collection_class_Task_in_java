

public class DoubleLinkedList1 {
    Node head;
    int length=0;
    class Node {
        int t;
        Node next;
        Node previous;

        Node(int given) {
            this.t = given;
            next = null;
            previous = null;
        }
    }

    public void addFirst(int i) {
        Node newnode = new Node(i);
        if (head == null) {
            length=length+1;
            head = newnode;
            head.previous = null;
            return;
        }
        length=length+1;
        newnode.next = head;
        head.previous = newnode;
        head = newnode;
    }

    public void printAll(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.t+" ");
            temp = temp.next;
        }
        System.out.println();

    }

    public void print_reverse(Node head){
          Node temp=head;
          while (temp!=null) {
            System.out.print(temp.t+"  ");
            temp=temp.previous;
          }
          System.out.println();
    }

    public void print_by_random(Node ele){
             while (ele.previous!=null) {
                ele=ele.previous;
             }
             while (ele!=null) {
                System.out.print(ele.t+" ");
                ele=ele.next;
             }
    }
    public void addlast(int val){
        Node newnode=new Node(val);

        if (head==null) {
            length=length+1;
            head=newnode;
            head.previous=null;
            return;
        }

        Node temp=head;
         while (temp.next!=null) {
            temp=temp.next;
         }
        length=length+1;
         temp.next=newnode;
         newnode.previous=temp;  
    }

    public void insertAt(int index,int val){
        Node temp=head;
            int i=0;
            while (true) {
                if(i==index-1){
                    break;
                }
                temp=temp.next;
                i++;
            }

            Node curr=temp.next;
            Node newNode=new Node(val);

            newNode.next=curr;
            newNode.previous=temp;
            temp.next=newNode;
            curr.previous=newNode;
    }


    public void deleteAt(int index){
        if (index==0) {
            head=head.next;
            head.previous=null;
            return;
        }
        Node temp=head;
        int i=0;
        while (true) {
             if (i==(index-1)) {
                break;
             }  
             temp=temp.next; 
             i++;
        }
        Node curr=temp.next.next;
        temp.next=curr;
        curr.previous=temp;

    }


    public boolean check_palindrome(Node head){
        Node tailNode=head;
        Node temp=head;
        while (tailNode.next!=null) {
            tailNode=tailNode.next;
        }
        for(int i=0;i<length/2;i++){
             if(temp.t!=tailNode.t){
                 return false;
             } 
             temp=temp.next;
             tailNode=tailNode.previous;
        }
        return true;
    }
 
    public void two_sum_in_linked_list(Node head,int target){
         Node tail=head;
         Node temp=head;

         while (tail.next!=null) {
            tail=tail.next;
         }
         while (temp.t<tail.t) {
              if (temp.t+tail.t==target) {
                 System.out.println("Element "+temp.t+" and "+tail.t+" = "+target);
                 break;
              }
              else if (temp.t+tail.t>target) {
                tail=tail.previous;
              }
              else{
               temp=temp.next;
              }
         }
         
    }

    public void check_distance_min_and_min(Node head){
          Node temp=head;
          Node temp2=head.next;
          while (temp.next!=null) {
            if () {
                
            }
            
          }
    }
    public static void main(String[] args) {

        DoubleLinkedList1 list=new DoubleLinkedList1();

        // list.addFirst(2);
        // list.addFirst(9);
        // list.addFirst(6);
        // list.addFirst(1);
        // list.addlast(5);
        // list.addFirst(11);
        // list.addlast(15);
        list.addFirst(9);
        list.addFirst(8);
        list.addFirst(7);
        list.addFirst(6);
        list.addFirst(5);
        list.addFirst(4);
        list.printAll(list.head);

        // System.out.println( list.check_palindrome(list.head));
        list.two_sum_in_linked_list(list.head, 12);
        // list.print_by_random(list.head.next.next);
        // System.out.println("\n");
        // System.out.println("Length is : "+list.length);
         // list.insertAt(3, 0);
         // list.insertAt(2, -2);
         // list.printAll(list.head);
         // list.deleteAt(1);
         // list.printAll(list.head);

        
    //     Node a=new Node(3);
    //     Node b=new Node(4);
    //     Node c=new Node(6);
    //     Node d=new Node(5);
    //     Node e=new Node(9);


    //    a.next=b;
    //    b.previous=a;
    //    b.next=c;
    //    c.previous=b;

    //    c.next=d;
    //    d.previous=c;
    //    d.next=e;
    //    e.previous=d;
    //    e.next=null;

    //    list.printAll(a);
    //    list.print_reverse(e);
    //    list.print_by_random(c);
        

        // DoubleLinkedList1 list = new DoubleLinkedList1();
        // list.addFirst(4);
        // list.addFirst(3);
        // list.addFirst(2);
        // list.addFirst(1);

        // list.printAll();
    }
}
