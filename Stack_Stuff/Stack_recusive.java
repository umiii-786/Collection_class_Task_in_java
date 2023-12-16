import java.util.Stack;

public class Stack_recusive {
    public static void reversestack(Stack<Integer> st){

         Stack<Integer> gt=new Stack<>();
         while (st.size()>0) {
            gt.push(st.pop());
         }
         Stack<Integer> rt=new Stack<>();
         while (gt.size()>0) {
            rt.push(gt.pop());
         }

         while (rt.size()>0) {
            st.push(rt.pop());
         }

    }


   public static void reversestack_recursion(Stack<Integer> st){
        if (st.size()==1) {
            return;
        }
        int top=st.pop();
        reversestack_recursion(st);
        insertAtbottom(st,top);
     
   }

   public static void insertAtbottom(Stack<Integer> st,int value){
         if (st.size()==0) {
            st.push(value);
            return;
         }

         int top=st.pop();
         insertAtbottom(st,value);
         st.push(top);
     
   }

    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(3);
        st.push(6);
        st.push(9);
        st.push(11);
        st.push(18);
        System.out.println(st);
        reversestack_recursion(st);
        System.out.println(st);

        // System.out.println(st);
       
        // st=reversestack(st);
        // System.out.println(st);


    }
}
