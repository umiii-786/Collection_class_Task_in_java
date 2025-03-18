import java.util.Stack;

public class ExpressionTree {
    static class Node{
       char ch;
       Node left;
       Node right;

       Node(char c){
            this.ch=c;
            this.left=null;
            this.right=null;
       }
        
    }
    public static Node MakeExpressionTree(String expr){
        Stack<Node> s=new Stack<>();
        for (int j = 0; j < expr.length(); j++) {
            char ch=expr.charAt(j);
            if (ch=='*' || ch=='+' || ch=='/' || ch=='-') {
                Node right=s.pop();
                Node left=s.pop();

                Node root=new Node(ch);
                root.left=left;
                root.right=right;

                s.push(root);
                
            }
            else{
                s.push(new Node(ch));
            }
        }
        // System.out.println(s);
        return s.pop();
    }

    public static void inorderTraversal(Node root){
        if (root!=null) {
            inorderTraversal(root.left);
            System.out.print(root.ch+"    ");
            inorderTraversal(root.right);
        }

    }
    public static void main(String[] args) {
       Node root=MakeExpressionTree("ab+cde+**");
        inorderTraversal(root);
    }
    
}
