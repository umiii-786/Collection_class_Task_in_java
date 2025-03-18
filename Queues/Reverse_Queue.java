import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Queue {
    public static void main(String[] args) {
        Queues_Implementing_my_LL queue=new Queues_Implementing_my_LL();
        Stack<Integer> s=new Stack<>();
        Queues_Implementing_my_LL helper=new Queues_Implementing_my_LL();
        queue.push(343);
        queue.push(456);
        queue.push(1);
        queue.push(11);
        queue.push(15);
        queue.push(19);
        queue.display();

        int k=3;
        for (int i = 0; i <k; i++) {
            s.push(queue.pop());
        }
        int n=queue.size();
        for(int i=0;i<k;i++){
            queue.push(s.pop());
        }

        for(int i=0;i<n;i++){
           int v =queue.pop();
           queue.push(v);
        }
      
        System.out.println("\n");
        queue.display();

        // for(int i=0;i<6;i++){
        //     s.push(queue.pop());
        // }
        // for (int i = 0; i < 6; i++) {
        //     queue.push(s.pop());
        // }
        // queue.display();

    }
}
