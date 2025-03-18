public class firstImplementation {
    static Node root = new Node();

    static class Node {
        Node[] children;
        boolean EndOfWord;

        Node() {
            children = new Node[26];
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            EndOfWord = false;
        }
    }

    // the insertion operation in the trie
    // comsume the O(L) time cmplexity, where L is the length of word
    public static void CreateTrie(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int letterIndx = word.charAt(i) - 97;
            if (temp.children[letterIndx] == null) {
                Node newNode = new Node();
                temp.children[letterIndx] = newNode;
            }
            if (i == word.length() - 1) {
                temp.children[letterIndx].EndOfWord = true;
            }
            temp = temp.children[letterIndx];
        }
    }

    public static boolean searchword(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            int letterindx = word.charAt(i) - 97;
            if (temp.children[letterindx] == null) {
                return false;
            }
            if (i == word.length() - 1 && temp.children[letterindx].EndOfWord == false) {
                return false;
            }
            temp = temp.children[letterindx];
        }
        return true;

    }

    public static Boolean Word_Break_Problem(String Word) {
        if (Word.length()>0) {
            return true;
        }
     
        for (int i = 1; i < Word.length(); i++) {
            boolean firsthalf =searchword(Word.substring(0,i));
            if (firsthalf && Word_Break_Problem(Word.substring(i))) {
                return true;
            }
        }
        
        return false;

    }

    public static boolean startPrefix(String prefix){
        Node temp=root;
        for (int i = 0; i < prefix.length(); i++) {
            int indx=prefix.charAt(i)-97;
            if (temp.children[indx]==null) {
                return false;
            }  
            if (temp.children[indx]!=null) {
                 temp=temp.children[indx];
            } 
        }

        return 
        true;


    }

    public static void main(String[] args) {
        String words[] = { "apple", "app", "mango", "man", "women"};
        for (String word : words) {
            CreateTrie(word);
            // System.out.println(word);
        }

        // System.out.println(searchword("i"));
        System.out.println(Word_Break_Problem("ilikesamsung"));
        System.out.println(startPrefix("moon"));

    }
}
