import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Binary_Search_Tree1 {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int d) {
            this.data = d;
            left = null;
            right = null;
        }

    }

    static class BTC {

        // static int index = -1;

        public Node Build_BTC(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }
            if (val > root.data) {
                root.right = Build_BTC(root.right, val);

            }
            if (val < root.data) {
                root.left = Build_BTC(root.left, val);
            }
            return root;
        }

        public void Display_by_Inorder(Node root) {
            if (root == null) {
                return;
            }

            Display_by_Inorder(root.left);
            System.out.print(root.data + "   ");
            Display_by_Inorder(root.right);
        }

        public static boolean check(Node rootNode, int val) {
            if (rootNode == null) {
                return false;
            } else if (rootNode.data > val) {
                boolean ch = check(rootNode.left, val);
                return ch;

            } else if (rootNode.data < val) {
                boolean ch = check(rootNode.right, val);
                return ch;
            } else {
                return true;
            }
        }


        public static void Display_In_Range(Node root, int x, int y) {
            if (root == null) {
                return;
            }
            if (root.data >= x && root.data <= y) {
                Display_In_Range(root.left, x, y);
                System.out.print(root.data + "   ");
                Display_In_Range(root.right, x, y);

            } else if (root.data >= y) {
                Display_In_Range(root.left, x, y);
            }

            else {
                Display_In_Range(root.right, x, y);
            }
        }

        public void PrintPath(ArrayList<Integer> list) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + "   ");
            }
            System.out.println();
        }

        public void Path_Root_2_leaf(Node root, ArrayList<Integer> list) {
            if (root == null) {
                return;
            }

            list.add(root.data);
            if (root.left == null && root.right == null) {
                PrintPath(list);
            } else {
                Path_Root_2_leaf(root.left, list);
                Path_Root_2_leaf(root.right, list);
            }
            list.remove(list.size() - 1);
        }



        class Pair{
            Node node;
            int key;

            Pair(int k,Node n){
                this.key=k;    
                this.node=n;
            }
        }

        public void Vertical_Order_Traversal(Node rootNode){
          Queue<Pair> q=new LinkedList<>();
          Map<Integer,ArrayList<Integer>> mp=new HashMap<>();
          if (rootNode==null) {
              System.out.println("Tree is empty");
              return;
          }
         q.add(new Pair(0,rootNode));
         while (q.size()>0) {
            Pair pr=q.remove();
            if (mp.containsKey(pr.key)) {
                mp.get(pr.key).add(pr.node.data);
            }
            else{
                ArrayList<Integer> arr=new ArrayList<>();
                arr.add(pr.node.data);
                mp.put(pr.key,arr);
            }

            if (pr.node.left!=null) {
                Pair newpr=new Pair(pr.key-1, rootNode.left);
                q.add(newpr);
            }
            if (pr.node.right!=null) {
                Pair newpr=new Pair(pr.key+1, rootNode.right);
                q.add(newpr);
            }   
         }

         for (Map.Entry<Integer,ArrayList<Integer>> ele : mp.entrySet()) {
            ArrayList<Integer> arr= ele.getValue();
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i)+"    ");
            }
            System.out.println("\n");
         }
        }
        public boolean Two_Sum_Check(Node rootNode,int sum){
            HashMap<Integer,Integer> mp=new HashMap<>();
            boolean ch=Find_Two_Sum_Check(rootNode, sum,mp);
            if (ch) {
                return true;
            }
            else{
                return false;
            }
        }


        private boolean Find_Two_Sum_Check(Node rootNode,int sum,HashMap<Integer,Integer> mp){
            if (rootNode==null) {
                return false;
            }
            if (mp.containsKey(sum-rootNode.data)) {
                return true; 
            }
            else{
                mp.put(rootNode.data, null);
                boolean inleft=Find_Two_Sum_Check(rootNode.left, sum, mp);
                boolean inright=Find_Two_Sum_Check(rootNode.right, sum, mp);
                if (inleft || inright) {
                    return true;
                } 
            }
            return false;
        }
        public void Find_Ceil_and_Floor_value(Node rooNode,int val){
           ArrayList<Integer> arr=new ArrayList<>();
           Get_Ceil_and_Floor_Values(rooNode,val,arr);
           int i;
           for ( i = 0; i < arr.size(); i++) {
               if (arr.get(i)>=val) {
                  break;
               }
           }
           System.out.println(i);

           System.out.println("the floor value of "+val+"  is "+arr.get(i-1));
           System.out.println("the Ceil value of "+val+"  is "+arr.get(i+1));
        }

        public void Get_Ceil_and_Floor_Values(Node rootNode,int val,ArrayList<Integer> arr ){
            if (rootNode==null) {
                return;
            }
            Get_Ceil_and_Floor_Values(rootNode.left,val,arr);
            arr.add(rootNode.data);
            Get_Ceil_and_Floor_Values(rootNode.right,val,arr);
        }


       
        public int findCeil_M2(Node rooNode,int val){
             int ans=Integer.MAX_VALUE;
             while (rooNode!=null) {
                if (rooNode.data==val) {
                    return rooNode.data;
                }
                
                if (rooNode.data>val) {
                    ans=rooNode.data;
                    rooNode=rooNode.left;
                }
                else{
                    rooNode=rooNode.right;
                }
             }

             return ans;
        }

        public int findFloor_M2(Node rooNode,int val){
            int ans=Integer.MIN_VALUE;
            while (rooNode!=null) {
                if (rooNode.data==val) {
                    return rooNode.data;
                }
                if (rooNode.data<val) {
                    ans=rooNode.data;
                    rooNode=rooNode.right;
                }
                else{
                    rooNode=rooNode.left;
                }
            }
            return ans;
        }

        public Node deleteNode(Node rootNode,int val){
                if (rootNode==null) {
                    System.out.println("element is not present in tree ");
                    return null;
                }
                else if(rootNode.data==val){
                    if (rootNode.left==null && rootNode.right==null) {
                        return null;
                    }
                    else if(rootNode.left==null && rootNode.right!=null){
                        return rootNode.right;
                    }
                    else if (rootNode.left!=null && rootNode.right==null) {
                        return rootNode.left;
                    }
                    else {
                        System.out.println("hn ");
                        Node succssorele=inorderSuccessor(rootNode.right);
                        System.out.println(succssorele.data);
                        rootNode.data=succssorele.data;
                        rootNode.right=deleteNode(succssorele, succssorele.data);
                        return rootNode;
                    }
                }
                else if (val>rootNode.data) {
                    rootNode.right=deleteNode(rootNode.right, val);
                }
                else if (val<rootNode.data) {
                    rootNode.left=deleteNode(rootNode.left, val);
                }

                return rootNode;

            }

            public Node inorderSuccessor(Node findElement){
                if (findElement.left==null) {
                    return findElement;
                }
                if (findElement.left!=null) {
                    return findElement.left;
                }
                 findElement=inorderSuccessor(findElement.left);
                 return findElement;
            }


        }


    public static void main(String[] args) {
        int arr[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;
        BTC tree = new BTC();
        for (int i = 0; i < arr.length; i++) {
            root = tree.Build_BTC(root, arr[i]);
        }

        tree.Display_by_Inorder(root);
        tree.deleteNode(root,1);
        System.out.println("\n");
        tree.Display_by_Inorder(root);

        
        // System.out.println(tree.check(root, 2));

        System.out.println();
        // tree.Vertical_Order_Traversal(root);
    //    System.out.println(tree.Two_Sum_Check(root,7)+"    ");
    //    tree.Find_Ceil_and_Floor_value(root,3);
    //   System.out.println(tree.findCeil_M2(root, 4));
    //   System.out.println(tree.findFloor_M2(root, 5));
    
        // tree.Display_In_Range(oot, 2,5);
        // tree.Path_Root_2_leaf(root, new ArrayList<>());
        // root=tree.deleteNode(root,3);
        // tree.Display_by_Inorder(root);
    }
}
