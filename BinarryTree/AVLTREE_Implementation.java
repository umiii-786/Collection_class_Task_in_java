import java.util.LinkedList;
import java.util.Queue;

public class AVLTREE_Implementation {
    static class Node {
        float data;
        Node left;
        Node right;

        Node(float d) {
            this.data = d;
            this.left = null;
            this.right = null;
        }
    }

    static class AVLTREE {

        public Node MakeTree(Node root, float val) {
            if (root == null) {
                return new Node(val);
            }

            if (val > root.data) {
                root.right = MakeTree(root.right, val);
            }

            if (root.data > val) {
                root.left = MakeTree(root.left, val);
            }

            int balance = FindBalance(root);
            if (balance == 0 || balance == -1 || balance == 1) {

            }

            else {
                String rotationIndicate = checkRotation(root, val);
                System.out.println(rotationIndicate);
                if (rotationIndicate.equals("RR")) {
                    root = rotateRR(root);
                } else if (rotationIndicate.equals("LL")) {
                    root = rotateLL(root);
                } else if (rotationIndicate.equals("RL")) {
                    root = rotateRL(root);
                } else if (rotationIndicate.equals("LR")) {
                    root = rotateLR(root);

                }
            }
            return root;
        }

        private Node rotateRL(Node unbalancNode) {
            Node belownode = unbalancNode.right;
            unbalancNode.right = null;
            Node insertnode = belownode.left;
            belownode.left = null;

            if (insertnode.right != null) {
                belownode.left = insertnode.right;
            }
            insertnode.right = belownode;
            unbalancNode.right = insertnode;

            belownode = rotateRR(unbalancNode);

            return belownode;

        }

        private Node rotateRR(Node unbalanceNode) {
            Node belownode = unbalanceNode.right;

            if (belownode.left != null) {
                unbalanceNode.right = belownode.left;
            } else {
                unbalanceNode.right = null;
            }
            belownode.left = unbalanceNode;
            return belownode;
        }

        private Node rotateLL(Node unbalanceNode) {
            Node belownode = unbalanceNode.left;
            if (belownode.right != null) {
                unbalanceNode.left = belownode.right;
            } else {
                unbalanceNode.left = null;
            }
            belownode.right = unbalanceNode;
            return belownode;
        }

        private Node rotateLR(Node unbalanceNode) {
            Node belowNode = unbalanceNode.left;
            unbalanceNode.left = null;
            Node insertNode = belowNode.right;

            belowNode.right = null;
            if (insertNode.left != null) {
                belowNode.right = insertNode.left;
            }
            insertNode.left = belowNode;
            unbalanceNode.left = insertNode;

            belowNode = rotateLL(unbalanceNode);
            return belowNode;
        }

        private static String checkRotation(Node node, float val) {
            String rotationIndicate = "";
            for (int i = 0; i <= 1; i++) {

                if (val > node.data) {
                    rotationIndicate += "R";
                    node = node.right;
                } else if (val < node.data) {
                    rotationIndicate += "L";
                    node = node.left;
                }

            }

            System.out.println(rotationIndicate + " their function");
            return rotationIndicate;
        }

        public static int FindBalance(Node root) {
            int lefth = height(root.left);
            int righth = height(root.right);
            int balance = lefth - righth;
            return balance;
        }

        public static int height(Node rootNode) {
            if (rootNode == null) {
                return 0;
            }
            int lefth = height(rootNode.left);
            int righth = height(rootNode.right);
            int h = Math.max(lefth, righth) + 1;
            return h;

        }

        public static void inorderTraversal(Node rootNode) {
            if (rootNode == null) {
                return;
            }
            inorderTraversal(rootNode.left);
            System.out.print(rootNode.data + "   ");
            inorderTraversal(rootNode.right);
        }

        public void Level_Order_Traversal(Node rootNode) {
            Queue<Node> q = new LinkedList<>();
            q.add(rootNode);
            q.add(null);
            while (q.size() > 0) {
                Node temp = q.remove();
                if (temp == null) {
                    System.out.println();
                    if (q.size() == 0) {
                        break;
                    }
                    q.add(null);
                } else {

                    System.out.print(temp.data + "  ");
                    if (temp.left != null) {
                        q.add(temp.left);
                    }
                    if (temp.right != null) {
                        q.add(temp.right);
                    }

                }
            }
        }

        public Node DeleteNode(Node root, float val) {
            if (root == null) {
                System.out.println("element is not exist in Tree");
                return null;
            }

            else if (root.data == val) {
                if (root.left == null && root.right == null) {
                    return null;
                } else if (root.left != null && root.right == null) {
                    return root.left;
                } else if (root.right != null && root.left == null) {
                    return root.right;
                } else {
                    Node inorderSuccessor = inorderSuccessor(root.right);
                    root.data = inorderSuccessor.data;
                    root.right = DeleteNode(inorderSuccessor, inorderSuccessor.data);
                }

            }

            else if (val > root.data) {
                root.right = DeleteNode(root.right, val);
            } else if (val < root.data) {
                root.left = DeleteNode(root.left, val);
            }

            int balanceFactor=FindBalance(root);
            if (balanceFactor == 0 || balanceFactor == -1 || balanceFactor == 1) {

            }
            else {
                root = Make_Balance_After_Deletion(root, val);
            }

            return root;
        }

        public Node Make_Balance_After_Deletion(Node node, float val) {
            int balanceFactor;
            if (val > node.data) {   // R 
                balanceFactor = FindBalance(node.left);
                if ( balanceFactor == -1) {
                    return rotateLR(node);
                } 
                else  {
                    return rotateLL(node);
                }
                // if (balanceFactor == 0 || balanceFactor==1)
              

            }
            else{ // L

                balanceFactor = FindBalance(node.right);
                if ( balanceFactor == 1) {
                    return rotateRL(node);
                } 
                else  {
                    return rotateRR(node);
                }
                // (balanceFactor == 0 || balanceFactor==-1)
            }

        }

        public Node inorderSuccessor(Node successorNode) {

            if (successorNode.left == null) {
                return successorNode;
            }
            successorNode.left = inorderSuccessor(successorNode.left);
            return successorNode;

        }
    }

    public static void main(String[] args) {
        float arr[] = { 21, 26, 30, 9, 4, 14, 28, 18, 15, 10, 2, 3, 7 };
        AVLTREE tree = new AVLTREE();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = tree.MakeTree(root, arr[i]);
        }
        tree.Level_Order_Traversal(root);
        tree.DeleteNode(root, 2);
        System.out.println("  ");
        tree.Level_Order_Traversal(root);
        tree.DeleteNode(root, 3);
        System.out.println("  ");
        tree.Level_Order_Traversal(root);
        tree.DeleteNode(root, 10);
        System.out.println("  ");
        tree.Level_Order_Traversal(root);

    }
}
