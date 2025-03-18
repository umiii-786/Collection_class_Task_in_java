import java.util.Scanner;
import java.util.Stack;

public class Evaluate_PostFix_M2 {
    

    public static int evalute(int val1,int val2, char op){
         if (op=='+') {
            return val1+val2;
         }
         if (op=='-') {
            return val1-val2;
         }
         if (op=='*') {
            return val1*val2;
         }
         if (op=='/') {
            return val1/val2;
         }
        return 0;

    }

    public static int evaluate_PostFix(String exp){
        Stack<Integer> number=new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);
            if (ch>='0' && ch<='9') {
                int v=(int)ch-48;
                number.push(v);
            }
            else{
                int val2=number.pop();
                int val1=number.pop();
                int ans=evalute(val1, val2, ch);
                number.push(ans);
            }
        }
        
         return number.pop();
    }

    
    public static void main(String[] args) {
        System.out.println(" enter the expression :");
        Scanner sc=new Scanner(System.in);

        String exp=sc.nextLine();
        System.out.println("evaluation is "+evaluate_PostFix(exp));
        System.out.println("helllo woelrew");

    }
}
