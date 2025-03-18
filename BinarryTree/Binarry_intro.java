public class Binarry_intro{
    static class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        Node(int d){
            data=d;
            parent=null;
            left=null;
            right=null;
        }
    }

    public static void main(String[] args) {
        Node root=null;
        Node temp=null; 
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node newnNode=new Node(nodes[0]);
        root=newnNode;
        temp=newnNode;
        int count=0;
        for (int i = 0; i < nodes.length; i++) {
            boolean check=false;
            if (nodes[i]!=-1) {
                Node newnode=new Node(nodes[i]);
                temp.left=newnode;
                newnode.parent=temp;
                temp=temp.left;
            }
            else{
                if (temp==root) {
                    continue;
                } 
                temp=temp.parent;
            }
        }

         

    }
}