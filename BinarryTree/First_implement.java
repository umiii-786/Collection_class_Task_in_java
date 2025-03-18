import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class First_implement {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
        }
    }

    static class Binarry_Tree {
        int indx = -1;
        int size = 0;

        public Node Make_Tree(int arr[]) {
            indx++;

            if (arr[indx] == -1) {
                return null;
            }

            Node newnode = new Node(arr[indx]);
            newnode.left = Make_Tree(arr);
            newnode.right = Make_Tree(arr);
            size++;
            return newnode;
        }

        public void Display_by_preorder(Node rootNode) {
            if (rootNode == null) {
                return;
            }
            System.out.print(rootNode.data + "    ");
            Display_by_preorder(rootNode.left);
            Display_by_preorder(rootNode.right);
        }

        public void Display_by_Inorder(Node rootNode) {
            if (rootNode == null) {
                return;
            }
            Display_by_Inorder(rootNode.left);
            System.out.print(rootNode.data + "   ");
            Display_by_Inorder(rootNode.right);

        }

        public void Display_by_PostOrder(Node root) {
            if (root == null) {
                return;
            }
            Display_by_PostOrder(root.left);
            Display_by_PostOrder(root.right);
            System.out.println(root.data);

        }

        public void Display_by_Level(Node rNode) {
            Queue<Node> q = new LinkedList<>();
            q.add(rNode);
            q.add(null);

            while (!q.isEmpty()) {
                Node temp = q.remove();
                if (temp == null) {
                    System.out.println("\n");
                    if (!q.isEmpty()) {
                        q.add(temp);
                    }
                }

                else {
                    System.out.print(temp.data + "    ");
                    if (temp.left == null && temp.right != null) {
                        q.add(temp.right);

                    } else if (temp.left != null && temp.right == null) {
                        q.add(temp.left);
                        continue;
                    } else if (temp.left == null && temp.right == null) {
                        continue;
                    } else {
                        q.add(temp.left);
                        q.add(temp.right);
                    }

                }
            }

        }

        public int countNodes(Node rooNode) {
            if (rooNode == null) {
                return 0;
            }
            int leftnode = countNodes(rooNode.left);
            int rightnode = countNodes(rooNode.right);
            return leftnode + rightnode + 1;
        }

        public int sum_of_nodes(Node root) {
            if (root == null) {
                return 0;
            }
            int sum = root.data;
            sum += sum_of_nodes(root.left);
            sum += sum_of_nodes(root.right);
            return sum;
        }

        public int Tree_height(Node rooNode) {
            if (rooNode == null) {
                return 0;
            }
            int leftHeight = Tree_height(rooNode.left);
            int rightHeight = Tree_height(rooNode.right);
            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            } else {
                return rightHeight + 1;
            }
        }

        public int Diameter(Node rootNode) {
            if (rootNode == null) {
                return 0;
            }
            int leftD = Diameter(rootNode.left);
            int rightD = Diameter(rootNode.right);
            int rootD = Tree_height(rootNode.left) + Tree_height(rootNode.right) + 1;
            int max = Math.max(rootD, Math.max(leftD, rightD));
            return max;
        }

        static class tree_info {
            int heigh;
            int dim;

            tree_info(int h, int d) {
                this.heigh = h;
                this.dim = d;
            }
        }

        public static tree_info M2_Diameter(Node rooNode) {
            if (rooNode == null) {
                return new tree_info(0, 0);
            }

            tree_info left = M2_Diameter(rooNode.left);
            tree_info right = M2_Diameter(rooNode.right);
            int myheight = Math.max(left.heigh, right.heigh) + 1;

            int dim1 = left.dim;
            int dim2 = right.dim;
            int dim3 = left.heigh + right.heigh + 1;

            int realDim = Math.max(Math.max(dim1, dim2), dim3);
            return new tree_info(myheight, realDim);
        }

        public int sum_kth_level_Nodes(Node rooNode, int level) {
            int sum = 0;
            Queue<Node> q = new LinkedList<>();
            q.add(rooNode);
            q.add(null);
            int i = 1;
            while (true) {
                if (i == level) {
                    break;
                }
                if (q.peek() == null) {
                    i++;
                    q.add(q.remove());

                    if (level == i) {
                        break;
                    }
                }
                Node top = q.remove();
                if (top.left == null && top.right != null) {
                    q.add(top.right);
                } else if (top.right == null && top.left != null) {
                    q.add(rooNode.left);
                } else if (top.right == null && top.left == null) {

                } else {
                    q.add(top.left);
                    q.add(top.right);
                }
            }
            while (q.peek() != null) {
                sum += q.remove().data;
            }
            if (sum == 0) {
                System.out.print(" level is not exist ");
                return -1;
            }

            return sum;

        }

        public boolean Isidentical(Node root, Node subroot) {
            if (root == null && subroot == null) {
                return true;
            }
            if (root == null || subroot == null) {
                return false;
            }
            if (root.data == subroot.data) {
                boolean inleft = Isidentical(root.left, subroot.left);
                boolean inright = Isidentical(root.right, subroot.right);
                return inleft && inright;
            }
            return false;

        }

        public boolean isSubstree(Node root, Node subroot) {
            if (subroot == null) {
                return true;
            }
            if (root == null) {
                return false;
            }

            if (root.data == subroot.data) {
                if (Isidentical(root, subroot)) {
                    return true;
                } else {
                    return false;
                }
            }

            boolean leftcheck = isSubstree(root.left, subroot);
            boolean rightcheck = isSubstree(root.right, subroot);

            if (leftcheck || rightcheck) {
                return true;
            }
            return false;
        }

        public void Print_Left_View(Node rootNode) {
            Queue<Node> q = new LinkedList<>();
            q.add(rootNode);
            System.out.print(rootNode.data + "    ");
            while (q.size() > 0) {
                Node node = q.remove();
                if (node.left != null && node.right == null) {
                    System.out.println(node.left.data);
                    q.add(node.left);
                } else if (node.left == null && node.right != null) {
                    q.add(node.right);
                } else if (node.left == null && node.right == null) {

                } else {
                    System.out.print(node.left.data + "    ");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }

        public void Print_Right_View(Node rootNode) {
            Queue<Node> q = new LinkedList<>();
            q.add(rootNode);
            System.out.print(rootNode.data + "    ");
            while (q.size() > 0) {
                Node node = q.remove();
                if (node.left == null && node.right != null) {
                    System.out.print(node.right.data + "     ");
                    q.add(node.right);
                } else if (node.left != null && node.right == null) {
                    q.add(node.left);
                } else if (node.left == null && node.right == null) {

                } else {
                    System.out.print(node.right.data + "    ");
                    q.add(node.left);
                    q.add(node.right);
                }
            }
        }

        public int find_maximun_node_in_tree(Node root) {
            if (root == null) {
                return Integer.MIN_VALUE;
            }
            int rootval = root.data;
            int leftval = find_maximun_node_in_tree(root.left);
            int rightval = find_maximun_node_in_tree(root.right);
            return Math.max(rootval, Math.max(leftval, rightval));
        }

        public int find_minimun_node_in_tree(Node root) {
            if (root == null) {
                return Integer.MAX_VALUE;
            }
            int rootval = root.data;
            int leftval = find_minimun_node_in_tree(root.left);
            int rightval = find_minimun_node_in_tree(root.right);

            return Math.min(rootval, Math.min(leftval, rightval));
        }

        public int max_num_method2(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int max = root.data;
            while (q.size() > 0) {
                Node node = q.remove();
                max = Math.max(max, node.data);
                if (node.left == null && node.right != null) {
                    q.add(node.right);
                } else if (node.left != null && node.right == null) {
                    q.add(node.left);
                } else if (node.left == null && node.right == null) {

                } else {
                    q.add(node.left);
                    q.add(node.right);
                }
            }

            return max;
        }

        public int min_number_method2(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int min = root.data;
            while (q.size() > 0) {
                Node node = q.remove();
                min = Math.min(min, node.data);
                if (node.left == null && node.right != null) {
                    q.add(node.right);
                }

                else if (node.left != null && node.right == null) {
                    q.add(node.left);
                }

                else if (node.left == null && node.right == null) {

                } else {
                    q.add(node.left);
                    q.add(node.right);
                }
            }
            return min;
        }

        public void Print_Left_View_Using_Method2(Node root) {

            ArrayList<Node> arr = new ArrayList<>();
            Find_left_View(root, arr, 0);
            System.out.println("\n");

            for (Node node : arr) {
                System.out.print(node.data + "     ");
            }
            System.out.println("\n");

        }

        public static void Find_left_View(Node rooNode, ArrayList<Node> arr, int level) {
            if (rooNode == null) {
                return;
            }

            if (arr.get(level) == null) {
                arr.add(rooNode);
            }

            Find_left_View(rooNode.left, arr, level + 1);
            Find_left_View(rooNode.right, arr, level + 1);
            return;
        }

        static class pair {
            int hd;
            Node node;

            pair(int hd, Node nd) {
                this.hd = hd;
                this.node = nd;
            }
        }

        public void Print_Top_View(Node rootNode) {

            Queue<pair> q = new LinkedList<>();
            HashMap<Integer, Integer> mp = new HashMap<>();
            q.add(new pair(0, rootNode));
            while (q.size() > 0) {
                pair p = q.remove();
                if (!mp.containsKey(p.hd)) {
                    mp.put(p.hd, p.node.data);
                }
                if (p.node.left != null) {
                    q.add(new pair(p.hd - 1, p.node.left));
                }
                if (p.node.right != null) {
                    q.add(new pair(p.hd + 1, p.node.right));
                }
            }

            for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
                System.out.print(entry.getValue() + "    ");
            }

        }

        Node head;
        Node previous;
        public void convert_to_DD_LL(Node rootNode){
            if (rootNode==null) {
                return;
            }

            convert_to_DD_LL(rootNode.left);
            if (previous==null) {
                head=rootNode;
            }
            else{
                rootNode.left=previous;
                previous.right=rootNode;
            }
            previous=rootNode;
            convert_to_DD_LL(rootNode.right);
        }

        public void DisplayDDLL(Node rootNode) {
            Node temp = rootNode;
            while (temp != null) {
                System.out.print(temp.data + "    ");
                temp = temp.right;
            }
        }

        public void display_Ancesstor(Node rootNode,int val1,int val2){
            ArrayList<Node> Ele1_ancessotor=new ArrayList<>();
            ArrayList<Node> Ele2_ancessotor=new ArrayList<>();

            find_anccesstor(Ele1_ancessotor,rootNode,val1);
            find_anccesstor(Ele2_ancessotor,rootNode,val2);
            System.out.println("element "+val1+" ancessotors are ");
            for (Node node : Ele1_ancessotor) {
                 System.out.print(node.data+"    ");
            }
            System.out.println();
            System.out.println("element "+val2+" ancesstors are ");
            for (Node node : Ele2_ancessotor) {
                System.out.print(node.data+"    ");
           }
        }
        private boolean find_anccesstor(ArrayList<Node> arrayList,Node root,int find){
            if (root==null) {
                return false;
            }
            if (root.data==find) {
                arrayList.add(root);
                return true;
            }
            else{
                boolean checkleft=find_anccesstor(arrayList,root.left,find);
                if (checkleft) {
                    arrayList.add(root);
                    return true;
                }  
                boolean checkright=find_anccesstor(arrayList,root.right,find); 
                if (checkright) {
                    arrayList.add(root);
                    return true;
                } 
            }
            return false;    
        }



        public Node Common_Ancesstor_Method2(Node root,int n1,int n2){
            if (root==null) {
                return null;
            }
            if (root.data==n1 || root.data==n2) {
                return root;
            }
            Node lefNode=Common_Ancesstor_Method2(root.left, n1, n2);
            Node rightNode=Common_Ancesstor_Method2(root.right, n1, n2);
            if (lefNode==null) {
                return rightNode;
            }
            if (rightNode==null) {
                return lefNode;
            }
            return root;
        }

    }

    public static void main(String[] args) {
        // int arr[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        int arr[] = { 3, -1, 1, 2, -1, -1, 4, -1, -1 };
        Binarry_Tree tree = new Binarry_Tree();
        Node root = tree.Make_Tree(arr);
        tree.Display_by_Level(root);
       System.out.println( tree.Common_Ancesstor_Method2(root, 2,1).data);
        // tree.display_Ancesstor(root,4,3);
        // tree.Display_by_Level(root);
        // tree.Display_by_Inorder(root);

        // tree.convert_to_DD_LL(root);
        // System.out.println(root.data);

        // tree.DisplayDDLL(tree.head);

        // System.out.println(tree.max_num_method2(root));
        // System.out.println(tree.min_number_method2(root));
        // tree.Print_Top_View(root);
  
        // tree.Print_Left_View(root);
        // System.out.println();
        // tree.Print_Left_View_Using_Method2(root);
        // int arr2[]={3,-1,-1};
        // Node subtree=tree.Make_Tree(arr2);
        // tree.Display_by_Level(subtree);

        // System.out.println(tree.sum_kth_level_Nodes(root, 6));
        // System.out.println(root.data);
        // tree.Display_by_preorder(root);
        // System.out.println("\n");
        // tree.Display_by_Inorder(root);
        // System.out.println("\n");
        // tree.Display_by_PostOrder(root);
        // tree.Display_by_Level(root);
        // System.out.println(tree.Tree_height(root));
        // System.out.println(tree.Tree_height(root));
        // System.out.println(tree.M2_Diameter(root).dim);

        // System.out.println(tree.countNodes(root));
        // System.out.println(tree.sum_of_nodes(root));

        // tree.Display_by_Level(root);

    }
}
