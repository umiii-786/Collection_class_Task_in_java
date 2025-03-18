import java.util.Stack;

public class Postfix_to_prefix {
    public static void main(String[] args) {
        String exp="95-34*6/+";
        Stack<String> value=new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);
            if (ch>='0' && ch<='9') {  
                value.push(Character.toString(ch));
            }
            else {
                String val2=value.pop();
                String val1=value.pop();
                value.push(ch+val1+val2);
            }
        }
        // +-95/*346
        System.out.println(value.pop());
    }
}
