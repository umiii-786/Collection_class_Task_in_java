import java.util.Stack;

public class Prefix_to_PostFix {
    public static void main(String[] args) {
       String preExp="+-95/*346";
    //    ans95-34*6/+
       Stack<String> value=new Stack<>();
       for (int i = preExp.length()-1; i >=0; i--) {
            char ch=preExp.charAt(i);
            if (ch>='0' && ch<='9') {
                String s=Character.toString(ch);
                value.push(s);
            }
            else{
                String val1=value.pop();
                String val2=value.pop();
                value.push(val1+val2+ch);
            }
       } 
       System.out.println(value.pop());
    }
}
