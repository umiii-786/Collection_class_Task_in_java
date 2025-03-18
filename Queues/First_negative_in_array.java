import java.util.LinkedList;
import java.util.Queue;

public class First_negative_in_array {
    public static int [] F_negative_in_window(){
        int arr[]={-12,1,7,8,15,-30,16,28};
        int n=arr.length;
         int k=3;
        Queue<Integer> q=new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<0) {
                q.add(i);
            }
        }
        System.out.println(q);
       
       
        int res[]=new int[n-k+1];
        // 12,-1,7,8,15,-30,16,28
        // 1,5
        // -1,-1,0,-30,-30,-30
        // 12,-1,-7,8,15,30,16,28
        //  -1,-1,-7,0,0,0
        // 1, 2, 4
        // -12,1,7,8,15,-30,16,28
        
        for (int i = 0; i <n-k+1; i++) {
            while (true) {
                if (q.size()==0) {
                    break;
                }
                if (q.peek()>=i && q.peek()<k+i) {
                     res[i]=arr[q.peek()];
                     break;
                }
                if (q.peek()>k+i-1) {
                    res[i]=0;
                    break; 
                }
                q.remove();
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+"  ,  ");
        }
        System.out.println();
        return arr;
    }
    public static void main(String[] args) {
        F_negative_in_window();
    }
}
