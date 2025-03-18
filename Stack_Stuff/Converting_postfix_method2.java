import java.util.Stack;
public class Converting_postfix_method2 {
    public static Boolean check_precidense(char exist_op, char Comming_op){
        if (exist_op=='(' && Comming_op==')') {
            return false;
        }
        if (Comming_op==')' &&  (  exist_op=='*' || exist_op=='/' || exist_op=='-' || exist_op=='+')) {
            System.out.println("hi");
            return true;
        }
        if (exist_op=='(') {
            return false;
        }

        if ((exist_op=='*' || exist_op=='/') && (Comming_op=='+' || Comming_op=='-')) {
            return true;
        }
        if ((exist_op=='-' || exist_op=='+') && (Comming_op=='+' || Comming_op=='-')) {
            return true;
        }
        if ((exist_op=='-' || exist_op=='+') && (Comming_op=='*' || Comming_op=='/')) {
            return false;
        }
        if (Comming_op=='(') {
            return false;
        }
       

        return true;
    }
    public static void main(String[] args) {
        String eq="(6+7)*(8/3)-2";
                    // 67+83/*2-
                    // 138*3/+2-
        String ans="";
        Stack<Character> st=new Stack<>();
       for (int i = 0; i < eq.length(); i++) {
            char ch=eq.charAt(i);
            if (ch>='0' && ch<='9') {
                ans+=ch;
            }
            else{
                while (st.size()>0 && check_precidense(st.peek(),ch)) {

                      ans+=st.pop();
                      System.out.println(ans);
                }

               if (ch==')') {
                st.pop();
               }
               else{
                   st.push(ch);
               } 
            }
       }
       while (st.size()>0) {
         ans+=st.pop();
       }
       System.out.println(ans);
    }
}
