import java.util.Stack;

public class Postfix_to_infix {
    public static String convert_to_infix(String str){
        Stack<String> value=new Stack();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (ch>='0' && ch<='9') {
                String s=Character.toString(ch);
                value.push(s);
            }
            else{
                String n2=value.pop();
                String n1=value.pop();
                value.push(n1+ch+n2);
            }
        }
        return value.pop();
    }
    public static int evaluate_the_postFix(String exp){
        Stack<Integer> num=new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);
            if (ch>='0' && ch<='9') {
                int n=(int)ch;
                System.out.println(n);
                num.push(n-48);
            }
            else{
                int n2=num.pop();
                int n1=num.pop();

                if (ch=='+')    num.push(n1+n2);
                else if (ch=='-')  num.push(n1-n2);   
                else if (ch=='*')  num.push(n1*n2);
                else if (ch=='/') num.push(n1/n2);    
            }
        }
        return num.pop();
    }

    public static void main(String[] args) {
        System.out.println(convert_to_infix("953+4*6/-"));
    }
}