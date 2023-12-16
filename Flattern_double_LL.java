class Node{
    int i;
    Node next;
    Node previous;
    Node child;

    Node(int i){
     this.i=i;
     next=null;
     previous=null;
     child=null;
    }
}

public class Flattern_double_LL {

    public Node flatten(Node heaNode){

          Node temp=heaNode;
          while (temp!=null) {
            if (temp.child!=null) {
                Node remaining_nodes=temp.next;
                Node setNodes=flatten(temp.child);
                temp.child=null;

                temp.next=setNodes;
                setNodes.previous=temp;
                while (setNodes.next!=null) {
                    setNodes=setNodes.next;
                }   
                setNodes.next=remaining_nodes;
                remaining_nodes.previous=setNodes;
            }
          }
          return heaNode;
    }
    public static void main(String[] args) {
        
    }
}
