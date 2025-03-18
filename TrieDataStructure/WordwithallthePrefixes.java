public class WordwithallthePrefixes {
    static Node root=new Node();
    static class Node {
        Node children[];
        boolean eof;

        Node(){
            children=new Node[26];
            eof=false;
        }
        
    }
    public static void createTrie(String word){
        Node temp=root;
        for (int i = 0; i < word.length(); i++) {
            int indx=word.charAt(i)-97;
            if (temp.children[indx]==null) {
                temp.children[indx]=new Node();
            }
            if (i==word.length()-1) {
                temp.children[indx].eof=true;
            }
            temp=temp.children[indx];
        }
    }

    static String Ans="";
    public static void Find_Laregest_Word_of_all_prefix(Node temp,String curr){
       
        for (int i = 0; i < 26; i++) {
             if (temp.children[i]!=null && temp.children[i].eof==true) {
                String tempcurr=curr+(char)(i+97);
                // System.out.println(curr);
                if (tempcurr.length()>Ans.length()) {
                    Ans=tempcurr;
                }
                Find_Laregest_Word_of_all_prefix(temp.children[i], curr+(char)(i+97));

             }
        }

    }
  public static void main(String[] args) {
    String word[]={"a","ac","acd","acde","acdh","b","bh","bhq","bhqa"};
    for (String string : word) {
        createTrie(string);
    }
   System.out.println(firstImplementation.searchword("acde"));
    Find_Laregest_Word_of_all_prefix(root, "");
    System.out.println(Ans);
    
  }  
}
