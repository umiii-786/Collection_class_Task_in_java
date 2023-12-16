import java.util.Stack;


public class Consecutive_span{

    public static int[] find_consecutive_span(int arr[]){
        int newarr[]=new int[arr.length];
        Stack<Integer> extra=new Stack<>();
        int count=1;
        Stack<Integer> st=new Stack<>();
        st.push(arr[0]);
        newarr[0]=1;
        for (int i =1; i <arr.length; i++) {

           while (st.peek()<arr[i] && st.size()>0) {
            System.out.println("hello");
            System.out.println(count);
              count++; 
              extra.push(st.pop()); 
           }

           if(extra.size()!=0){
            System.out.println("hi");
                while (extra.size()>0) {
                    st.push(extra.pop());
                }
           }
           newarr[i]=count;
           st.push(arr[i]);
           count=1;
        }
           return newarr;
    }
    public static void main(String[] args) {
       int arr[]={600,300,500,900,100,50};
       arr=find_consecutive_span(arr);
       for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"  ,");
       }

      
    }
}