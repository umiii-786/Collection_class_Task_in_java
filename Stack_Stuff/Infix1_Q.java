import java.util.Stack;

public class Infix1_Q {
    public static int solveInfix(String str) {
        Stack<Integer> number = new Stack<>();
        Stack<Character> operator = new Stack<>();
        System.out.println(str);
        String st="8+(40-5*5)/3";
       
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int n = (int) ch;
                System.out.println("pushing " + (n - 48));
                number.push((n - 48));
            } else if (operator.size() == 0 ||  ch=='('   || operator.peek()=='(') {
                System.out.println("pushing "+ch);
                operator.push(ch);
            } 
            else if ((ch == '+' || ch == '-' || ch==')') && (operator.peek()!='(' )  ) {
                
                int val2 = number.pop();
                int val1 = number.pop();
                char op = operator.pop();
                if (op == '-') {
                    number.push(val1 - val2);
                }
                else if (op == '+') {
                    number.push(val1 + val2);
                }
                else if (op == '*') {
                    number.push(val1 * val2);
                }
                else if (op == '/') {
                    number.push(val1 / val2);
                }
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
                    int val2 = number.pop();
                    int val1 = number.pop();

                    char op = operator.pop();
                    if (op == '-') {

                        number.push(val1 - val2);
                    }
                    if (op == '+') {

                        number.push(val1 + val2);
                    }
                    if (op == '*') {

                        number.push(val1 * val2);
                    }
                    if (op == '/') {

                        number.push(val1 / val2);
                    }
                    operator.push(ch);
                }
            }
        }
        System.out.println(number);
        System.out.println(operator);
        while (number.size() > 1) {
            int val2 = number.pop();
            int val1 = number.pop();
            char op = operator.pop();

            if (op == '-')
                number.push(val1 - val2);
            if (op == '+')
                number.push(val1 + val2);
            if (op == '*')
                number.push(val1 * val2);
            if (op == '/')
                number.push(val1 / val2);

        }

        return number.pop();
    }

    public static void main(String args[]) {

        System.out.println(solveInfix("9-5+3*4/6"));
            //  8-3/3
    }
}