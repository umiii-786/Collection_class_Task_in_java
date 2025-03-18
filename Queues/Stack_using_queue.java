import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Stack_using_queue {
    Queue<Integer> q=new LinkedList<>();
    Queue<Integer> helper=new LinkedList<>();
    public void push(int val){
            q.add(val);       
    }
    public int pop() {
        if (q.size()==0) {
            return -1;
        } 
        for (int i = 0; i < q.size()-1; i++) { 
            int v=q.remove();
            q.add(v);
        }
      
        int val=q.remove();
        return val;
    }
    public int peek() {
        if (q.size()==0) {
            return -1;
        }
        for (int i = 0; i < q.size()-1; i++) { 
            int v=q.remove();
            q.add(v);
        }
       
        int v=q.remove();
        q.add(v);
        return v;
    }

    public void display(){
        while (q.size()>0) {
            int v=q.remove();
            helper.add(v);
            System.out.print(v+" , ");
        }
        while(helper.size()>0){
            q.add(helper.remove());
        }
    }

    public static void main(String[] args) {
        Stack_using_queue q=new Stack_using_queue();
        q.push(3435);
        q.push(444);
        q.push(7676);
        q.display();
        System.err.println();
       System.out.println(q.peek());
       System.out.println(q.pop());
       System.out.println();
       q.display();
    }
}
