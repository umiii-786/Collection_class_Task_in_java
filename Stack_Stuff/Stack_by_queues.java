import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_by_queues {
    Queue<Integer> real=new LinkedList<>();
    Queue<Integer> helper=new LinkedList<>();

    int size=0;
    public void push(int val){
        real.add(val);
        size++;
    }
    public int peek(){
        if (size==0) {
            System.out.println("Stack is empty ");
            return -1;
        }
        for(int i=1;i<size;i++){
            helper.add(real.remove());
        }
        int val=real.remove();
        helper.add(val);
        return val;
    }
     public int pop()  {
        if (size==0) {
            System.out.println("Stack is empty ");
            return -1;
        }
        for(int i=1;i<size;i++){
            helper.add(real.remove());
        }
        int val=real.remove();
        size--;
        return val;
    }
    public void display(){
        int n=helper.size();
        for (int i = 0; i < n; i++) {
            real.add(helper.remove());
        }
        System.out.print("[");
        for (int i = 0; i <size; i++) {
            int val=real.remove();
            System.out.print(val+" ,");
            helper.add(val);
        }
        System.out.print("]");
        System.out.println("\n");

        // System.out.println(helper);
        for (int i = 0; i <size; i++) {
            real.add(helper.remove());
        }
    }

     public static void main(String[] args) {
        Stack_by_queues s=new Stack_by_queues();
        s.push(6);
        s.push(1);
        s.display();
       System.out.println("\n");
       System.out.println(s.pop());
       s.display();
       s.push(45);
       s.push(879);
       s.display();
    
       System.out.println(s.pop());
       s.display();
       System.out.println(s.pop());
       s.display();
       System.out.println(s.pop());
       s.display();
        
        // realueue<Integer> f=new LinkedList<>();
        // realueue<Integer> j=new LinkedList<>();
        // f.add(456);
        // f.add(12);
        // f.add(1255);
        // System.out.println(f);
        

        // Stack<Integer> st=new Stack<>();
        // for (int i = 0; i <3; i++) {
        //     j.add(f.remove());
        // }
        // System.out.println(j);
        // System.out.println(j.poll());

     }   
}
