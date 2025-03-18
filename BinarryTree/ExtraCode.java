// import java.util.HashMap;
// import java.util.LinkedList;
// import java.util.Queue;

// import org.w3c.dom.Node;

// public class ExtraCode {
//      public void Print_Top_View(Node root){
//             if (root==null) {
//                 System.out.println("Tree is empty ");
//                 return;
//             }
//             HashMap<Integer,Integer> mp=new HashMap<>();
//             find_top_view(root, mp);
//             System.out.println(mp.keySet());

//         }
//         private void find_top_view(Node root,HashMap<Integer, Integer> mp){
//           Queue<Node> q=new LinkedList<>();
//           q.add(root);
//           mp.put(root.data,0);
//           while (q.size()>0) {
//               Node node=q.remove();
//               int indx=mp.get(node.data);
//               if (node.left==null && node.right!=null) {
//                 insert_into(node.right.data,indx+1,mp);
//                 q.add(node.right);
//               }
//               else if (node.left!=null && node.right==null) {
//                    insert_into(node.left.data,indx-1,mp);
//                    q.add(node.left);
//               }
//               else if (node.left==null && node.right==null) {
                
//               }
//               else{
              
//                 insert_into(node.left.data,indx-1,mp);
//                 insert_into(node.right.data,indx+1,mp);
//                 q.add(node.left);
//                 q.add(node.right);
//               }
//           }
//         }
//         private void insert_into(int key,int val,HashMap<Integer,Integer> mp){
//             boolean check=mp.containsValue(val);
//             if (check) {
//                 return;
//             }
//             mp.put(key,val);
//         }
// }




// public  Node convert_Tree_into_DD_LL(Node rootNode){
//   rootNode=convert_to_DD_LL(rootNode);
//   while (rootNode.left!=null) {
//           rootNode=rootNode.left;
//   }
//   return rootNode;
// }

// private static Node convert_to_DD_LL(Node rootNode){
// if (rootNode==null) {
//     return null;
// }
// Node previous=convert_to_DD_LL(rootNode.left);
// rootNode.left=previous;
// if (previous!=null) {
//     previous.right=rootNode; 
// }
// Node next=convert_to_DD_LL(rootNode.right);
// rootNode.right=next;
// if (next!=null) {
//     next.left=rootNode;
//     return next;  
// }

// return rootNode;
// }

        // public static Node inorderSuccessor(Node inorderNode) {
        //     if (inorderNode.left == null) {
        //         return inorderNode;
        //     }
        //     Node successsor = inorderSuccessor(inorderNode.left);
        //     return successsor;
        // }

        // public static Node deleteNode(Node root, int val) {
        //     if (root == null) {
        //         return null;
        //     }

        //     else if (root.data > val) {
        //         root.left = deleteNode(root.left, val);
        //     }

        //     else if (root.data < val) {
        //         root.right = deleteNode(root.right, val);
        //     }

        //     else {

        //         if (root.left == null && root.right == null) {
        //             return null;
        //         } else if (root.left == null && root.right != null) {
        //             return root.right;
        //         } else if (root.left != null && root.right == null) {
        //             return root.left;
        //         } else {
        //             Node inorderSuccessor = inorderSuccessor(root.right);
        //             root.data = inorderSuccessor.data;
        //             root.right = deleteNode(root.right, inorderSuccessor.data);
        //             return root;
        //         }

        //     }

        //     return root;
        // }

