import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;


public class Infix_to_PostFix_M2 {
    public static boolean check_precidense(char st_op, char new_op){
        if (st_op==new_op) {
            return true;
        }
        else if ((st_op=='+' && new_op=='*') || (st_op=='+' && new_op=='/')) {
            return false;
        }

        else if ((st_op=='-' && new_op=='*') || (st_op=='-' && new_op=='/')) {
            return false;
        }
        else{
            return true;
        }
    }

    public static String Convert_to_PostFix(String exp){
        Stack<Character> st=new Stack<>();
        String ans="";
        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);

            if (ch>='0' && ch<='9') {
                ans+=ch;
                System.out.println(ans);
            }

            else{
                if (st.size()==0) {
                   st.push(ch);
                   System.out.println(st);
                }
               else{
                boolean check=check_precidense(st.peek(), ch);
                System.out.println(check);
                if (check) {
                    ans+=st.pop();
                }
                st.push(ch);
                }     
            }
        }

        while (st.size()>0) {
            ans+=st.pop();
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the expression :");
        String ex=sc.nextLine();
        System.out.println("postfix is "+Convert_to_PostFix(ex));
    }
}
