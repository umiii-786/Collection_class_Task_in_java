import java.util.Stack;

public class Prefix1 {

    public static String convert_into_prefix(String str){
        Stack<String> value=new Stack<>();
        Stack<Character> characters=new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            
            if (ch>='0' && ch<='9') {
                String st=Character.toString(ch);
                value.push(st);
            }
            else if(characters.size()==0){
                characters.push(ch);
            }

            else if(ch=='+' || ch=='-') {
                String n2=value.pop();
                String n1=value.pop();
                String stri=characters.pop()+n1+n2;
                value.push(stri);
                characters.push(ch);
            }

            else{
                if (characters.peek()=='+' || characters.peek()=='-') {
                      characters.push(ch);
                }
                else {
                    String n2=value.pop();
                    String n1=value.pop();
                    String stri=characters.pop()+n1+n2;
                    value.push(stri);
                    characters.push(ch);
                }
            }
        }

        while (characters.size()>0) {
            String n2=value.pop();
            String n1=value.pop();
            value.push(characters.pop()+n1+n2);
        }
        return value.pop();
    }


    public static String solvePrefix_with_bracket(String str) {
        Stack<String> value= new Stack<>();
        Stack<Character> operator = new Stack<>();
        // System.out.println(str);
        String st="8+(40-5*5)/3";
       
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                String n = Character.toString(ch);
                value.push(n);
            } else if (operator.size() == 0 ||  ch=='('   || operator.peek()=='(') {
                operator.push(ch);
            } 
            else if ((ch == '+' || ch == '-' || ch==')') && (operator.peek()!='(' )  ) {
                
                String val2 = value.pop();
                String val1 = value.pop();
                char op = operator.pop();
                value.push(op+val1+val2);
                if (ch==')') {
                    operator.pop();
                    continue;
                }
                operator.push(ch);   
            }

            else {
                if (operator.peek() == '+' || operator.peek() == '-') {
                    operator.push(ch);
                } else {
                    String val2 = value.pop();
                    String val1 = value.pop();
                    char op = operator.pop();
                    value.push(op+val1+val2);

                    operator.push(ch);
                }
            }
        }
        while (value.size() > 1) {
            String val2 = value.pop();
            String val1 = value.pop();
            char op = operator.pop();

            value.push(op+val1+val2);
        }
        return value.pop();
    }
    public static void main(String[] args) {
      
        System.out.println(convert_into_prefix("9-5+3*4/6"));
        System.out.println(solvePrefix_with_bracket("9-5+3*4/6"));
                                                            //  +9\*3-543
       


    }
}

