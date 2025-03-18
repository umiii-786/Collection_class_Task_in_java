
public class BTS2 {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int d){
            this.data=d;
            this.left=null;
            this.right=null;
        }
    }
    static class BTS_Tree{
       

        int size=0;
        public Node MakeTree(Node rootNode,int val){
             if (size==0) {
                size++;
                  return new Node(val);    
             }
             if (rootNode==null) {
                return new Node(val);
             }
             
             else if (rootNode.data>val) {
                rootNode.left=MakeTree(rootNode.left,val);
             }
             else if (rootNode.data<val) {
                rootNode.right=MakeTree(rootNode.right,val);
             }
             size++;
             return rootNode;
        }


        public void Display_by_Inorder(Node rootNode){
              if (rootNode==null) {
                  return;
              }
              Display_by_Inorder(rootNode.left);
              System.out.print(rootNode.data+"    ");
              Display_by_Inorder(rootNode.right);
        }


    }
    public static void main(String[] args) {
        int arr[] = { 5, 1, 3, 4, 2, 7 };
        BTS_Tree tree=new BTS_Tree();
        Node root=null;
        for (int i = 0; i < arr.length; i++) {
            root=tree.MakeTree(root,arr[i]);
        }
        tree.Display_by_Inorder(root);


        
    }
    
}

