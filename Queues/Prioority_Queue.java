public class Prioority_Queue {
    Node head;
    private int size=0;
    static class Node{
        int data;
        int priority;
        Node next;
        Node(int d,int p){
            this.data=d;
            this.priority=p;
            this.next=null;
        }
    }
    
    public static int getPriority(int data){
         return data%4;
    }
    public void add(int data){
        if (head==null) {
            Node newnode=new Node(data,0);
        }
          
    }
    public static void main(String[] args) {
    //   System.out.println(Math.abs(6*Math.random()));
      System.out.println(getPriority(25));
    }
}
