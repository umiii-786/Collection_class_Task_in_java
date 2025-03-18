import java.util.Stack;
public class Prefix_evaluation {
    public static String Prefix_to_infix(String st){
        Stack<String> value=new Stack<>();
        for (int i = st.length()-1; i >=0; i--) {
            char ch=st.charAt(i);
            if (ch>='0' && ch<='9') {
                value.push(Character.toString(ch));
            }
            else{
                String val1=value.pop();
                String val2=value.pop();
                value.push(val1+ch+val2);
            }
        }

        return value.pop();
    }
    public static void main(String[] args) {
        String exp="+-95/*346";

        Stack<Integer> st=new Stack<>();
        for (int i = exp.length()-1; i >=0; i--) {
            char ch=exp.charAt(i);
            if (ch>='0' && ch<='9') {
                int n=(int)ch-48;
                // System.out.println(n);
                st.push(n);
            }
            else{
                int val1=st.pop();
                int val2=st.pop();
                
                if (ch=='+') {
                    st.push(val1+val2);
                }
                if (ch=='-') {
                    st.push(val1-val2);
                }
                if (ch=='*') {
                    st.push(val1*val2);
                }
                if (ch=='/') {
                    st.push(val1/val2);
                }
            }
        }

        System.out.println(st.pop());
        System.out.println(Prefix_to_infix("+-95/*346"));

    }
}
