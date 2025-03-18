public class FindUniqueSubstr {
    static Node root = new Node();
    static int sumnodes = 1;

    static class Node {
        Node children[];
        boolean eof;

        Node() {
            children = new Node[26];
            eof = false;
        }
    }

    public static void createTrie(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int indx = word.charAt(i) - 97;
            if (temp.children[indx] == null) {
                temp.children[indx] = new Node();

            }
            if (i == word.length() - 1) {
                temp.eof = true;
                return;
            }
            temp = temp.children[indx];

        }
    }

    public static boolean startPrefix(String prefix) {

        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int indx = prefix.charAt(i) - 97;
            if (temp.children[indx] == null) {
                return false;
            }
            temp = temp.children[indx];
        }
        return true;
    }

    private int countTrieNodes(Node temp, String substr) {
        if (temp == null) {
            return 0;
        }
        for (int i = 0; i < temp.children.length; i++) {

            if (temp.children[i] != null) {
                String newsub = substr + (char) (i + 97);
                System.out.println(newsub);
                sumnodes = countTrieNodes(temp.children[i], newsub) + 1;
            }
        }
        return sumnodes;
    }
  

    private void Find_Each_Suffix(String word) {
        for (int i = 0; i < word.length(); i++) {
            createTrie(word.substring(i, word.length()));
        } 
    }

    public  int count_Unique_Substr(String str){
        Find_Each_Suffix(str);
        return countTrieNodes(root, " ");
    }

    public static void main(String[] args) {
         FindUniqueSubstr obj=new FindUniqueSubstr();
      System.out.println( "There are possible unique count of substr are "+obj.count_Unique_Substr("ababa"));
        
    }
}
