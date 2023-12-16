import java.util.Scanner;
import java.util.Stack;

public class Interview_Q_part1 {

    public static void make_balance(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.length() == 0 && ch == '(') {
                st.push(ch);
            }

            else {
                if (ch == '(') {
                    st.push(ch);
                }
            }
        }

    }

    public static int[] remove_consequetive_ele(int arr[]) {
        Stack<Integer> st = new Stack<>();

        st.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            
            if (st.peek() == arr[i]) {
                if (i==arr.length-1 || arr[i] != arr[i + 1]) {
                    st.pop();
                }
            }
            else {
                st.push(arr[i]);
            }
        }
        System.out.println(st + " and their size is " + st.size());
        int[] newarr = new int[st.size()];
        for (int i = newarr.length - 1; i >= 0; i--) {
            newarr[i] = st.pop();
        }

        return newarr;
    }

    public static boolean Isvalid(String str) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (st.size() != 0) {
                if ((st.peek().equals('(') && ch == ')')
                        || (st.peek().equals('[') && ch == ']')
                        || (st.peek().equals('{') && ch == '}'))
                    st.pop();

                else
                    return false;
            }

            else {
                return false;
            }

        }

        return true;
    }

    public static boolean check_balance(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                st.push(ch);
            } else {
                if (st.size() > 0 && st.peek() == '(')
                    st.pop();
                else
                    st.push(ch);
            }

        }
        if (st.size() == 0)
            return true;
        else
            return false;

    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 2, 434, 78, 3, 3, 1, 9, 0, 4, 4, 4, 4 };
        int[] res = remove_consequetive_ele(arr);
        for (int i : res) {
            System.out.println(i);
        }
        // Scanner sc = new Scanner(System.in);
        // System.out.println("enter the brackets ");
        // String brackets = sc.nextLine();
        // // System.out.println("after making balance is " + make_balance(brackets));

        // make_balance(brackets);
        // System.out.println("answer is ==> " + Isvalid(brackets));

    }
}
