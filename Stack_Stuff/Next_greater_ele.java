import java.util.Stack;

public class Next_greater_ele{

    public static int[] Next_greater(int arr[]){
      int newarr[]=new int[arr.length];
      int k=1;
      for (int i = 0; i < arr.length; i++) {
        newarr[i]=-1;
        for (int j = k; j < arr.length; j++) {
            if (arr[i]<arr[j]) {
              System.out.println(arr[j]);
              newarr[i]=arr[j];
              break;
            }
          }
          k++;
      }

      return newarr; 
    }



    public static void Next_greater_with_stack(int arr[]){

      int []newarr=new int[arr.length];
      Stack<Integer> st=new Stack<>();

      newarr[arr.length-1]=-1;
      st.push(arr[arr.length-1]);
      for (int i =arr.length-2; i >=0 ; i--) {
        
          while (st.peek()<arr[i] && st.size()>0) {
              System.out.println( st.pop());
            }
          
          if (st.size()==0){
            newarr[i]=-1;
          }

          else {
            newarr[i]=st.peek();
          }

          st.push(arr[i]);

       }
       for (int i = 0; i < newarr.length; i++) {
            System.out.println(newarr[i]);
       }
    } 


    public static void main(String[] args) {
        int arr[]={13,565,4676,2,6,-2,11,19};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ,");
        }
        System.out.println("\n");
      Next_greater_with_stack(arr);

      //   for(int i=0;i<arr.length;i++){
      //       System.out.print(arr[i]+" ,");
      //   }


    }
}