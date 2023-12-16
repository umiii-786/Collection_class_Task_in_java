import java.util.Scanner;
import java.util.Stack;

public class stack_demo {

    public void prinlnStack(Stack<Integer> st){
           if (st.size()==0) {
              return;
           }
           int top=st.pop();
           prinlnStack(st);
           System.out.println(top);
           st.push(top);
    }

    public void Insert_At_End(Stack<Integer> st, int value){
       System.out.println(st.size());
        if (st.size()==1) {
            System.out.println(st);
            int top=st.pop();
            st.push(value);
            st.push(top);
            System.out.println(st);
            return;
        }

        int top=st.pop();
        Insert_At_End(st,45);
        st.push(top);
    }

    public static void main(String[] args) {
        stack_demo obj=new stack_demo();
        Stack<Integer> st = new Stack<>();

        st.push(5);
        st.push(2);
        st.push(1);
        st.push(9);
        st.push(11);
        System.out.println(st);

        obj.Insert_At_End(st,45);
        System.out.println(st);

        // obj.prinlnStack(st);
        // System.out.println(st);
    //     Stack<Integer> newst = new Stack<>();
    //    while (st.size()>0) {
    //        newst.push( st.pop());
    //    }
    // //    System.out.println(newst);
    //    while (newst.size()>0) {
    //     System.out.print(newst.peek()+" ,");
    //     st.push(newst.pop());
    //    }

    //    System.out.println(st);
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter the index number on which you want to insert the value : ");
        // int index = sc.nextInt();
        // System.out.println("enter the value  :");
        // int value = sc.nextInt();

          


        // while (true) {
        //     if (st.size() == index) {
        //         st.push(value);
        //         while (newst.size() > 0) {
        //             st.push(newst.pop());
        //         }
        //         break;
        //     }
        //     newst.push(st.pop());
        // }

        // while (st.size()>index) {
        //     newst.push(st.pop());
        // }
        // st.push(value);
        // while (newst.size()>0) {
        //     st.push(newst.pop());
        // }
        // System.out.println(st);
        // System.out.println(st);

        // if (index==0) {
        // while (st.size()>1) {
        // newst.push(st.pop());
        // }
        // st.pop();
        // st.push(value);
        // System.out.println(st);
        // System.out.println(newst);
        // while (newst.size()>0) {
        // st.push(newst.pop());
        // }
        // }
        // System.out.println(st);
        // System.out.println(newst);

        // Stack<Integer> st = new Stack<>();
      

        // System.out.println("st is -->"+st);

        // Stack<Integer> gt = new Stack<>();
        // for (int i = st.size(); i > 0; i--) {
        // gt.push(st.pop());
        // }
        // // System.out.println(gt);

        // Stack<Integer> rt=new Stack<>();
        // for(int i=gt.size();i>0;i--){
        // rt.push(gt.pop());
        // }

        // // System.out.println(rt);

        // for (int i = rt.size(); i >0; i--) {
        // st.push(rt.pop());
        // }
        // System.out.println("st is -->"+st);

        // Stack<Integer> st=new Stack<>();
        // Stack<Integer> newst=new Stack<>();
        // st.push(3);
        // st.push(5);
        // st.push(7);
        // st.push(9);
        // st.push(11);
        // System.out.println(st);
        // for(int i=st.size();i>0;i--){
        // newst.push(st.pop());
        // }
        // for(int i=newst.size();i>0;i--){
        // st.push(newst.pop());
        // System.out.println(st);
        // }
        // for(int i=st.size();i>0;i--){
        // newst.push(st.pop());
        // }
        // System.out.println(newst);
    }
}
