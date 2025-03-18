import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class REorder_queue_using_queue {

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> helper = new LinkedList<>();
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

        for (int i = 0; i < n/2; i++) {
            helper.add(q.remove());
        }
        System.out.println(q);
        System.out.println(helper);

        for (int i = 0; i <n/2; i++) {
            q.add(helper.remove());
            int v=q.remove();
            q.add(v);
        }
        System.out.println(q);
    }
}
