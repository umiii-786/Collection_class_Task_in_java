import java.util.Stack;

public class negative_in_window {
    public static int[] negative_w(){
        int arr[]={12,-1,-7,8,-15,30,16,28};
        // 1,2,4,4,8,6,8,8
        // -9,-9,-9,-3,-4,-4,-6
        // -9,-9,-9,-4,-4
        // -1,-9,-9,-3,-3,-3

        int n=arr.length;
        int next_small[]=new int[n];
        Stack<Integer> st=new Stack<>();
        next_small[n-1]=n;
        st.push(n-1);
        System.out.println(n+" is ");
       
        for (int i =next_small.length-2; i>=0 ; i--) {
            while (st.size()>0 && arr[st.peek()]> arr[i] ) { 
                System.out.println("hell"+ st.pop());
            }
            if (st.size()==0) {
                next_small[i]=n;
            }
            else{
                next_small[i]=st.peek();
            }
            st.push(i);
        }
        
        System.out.println("window negative  are");
        for (int i = 0; i < next_small.length; i++) {
            System.out.print(next_small[i]+"  ,  ");
        }

        int k=3;
        int result[]=new int[n-k+1];
        // 12,-1,-7,8,-15,30,16,28
        // 1,2,4,4,8,6,8,8
        // -7,-7,-15,-15,-15,

        int j;
        for (int i = 0; i < n-k+1; i++) {
            j=i;
            if (j<=k+i) {
               
            }
            else{
                j=i;
            }
            while (j<k+i) {
                if (arr[j]<0) {
                    result[i]=arr[j];
                    System.out.println("breaking ");
                    break;
                }
                else{   
                    if(arr[j]>0){
                        result[i]=0;
                    }
                    System.out.println(j);
                    j=next_small[j];
                }
            }
        }

        System.out.println("\n window negative  are");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+"  ,  ");
        }

        // return result;
        return arr;
    } 
    public static void main(String[] args) {
        negative_w();
    }
}
