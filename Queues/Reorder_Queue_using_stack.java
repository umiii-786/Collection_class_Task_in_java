import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reorder_Queue_using_stack {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);

        System.out.println(q);
        int n=q.size();
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n/2; i++) {
            st.push(q.remove());
        }

        for (int i = 0; i < n/2; i++) {
            q.add(st.pop());
        }
        System.out.println(q);
        for (int i = 0; i < n/2; i++) {
            st.push(q.remove());
        }
        
        for (int i = 0; i <n/2; i++) {
            q.add(st.pop());
            int v=q.remove();
            q.add(v);
        }

        for (int i = 0; i <n; i++) {
            st.push(q.remove());
        }
        for (int i = 0; i < n; i++) {
            q.add(st.pop());
        }
        System.out.println(q);
    }
}
