import java.util.LinkedList;

public class Implementing_Hashmap {
    static class MyHashMap<K,V> {
       class Node{
         K key;
         V value;
         Node(K k,V v){
            this.key=k;
            this.value=v;
         }
      }
       private int initial_capacity=4;
       private float Load_factor=0.75f;
       private int entries=0;
       private LinkedList<Node> table[];
   
       
       private void initzialize_table(int cap){
            table= new LinkedList[cap];
            initzialize_linkedList();
       }
       private void initzialize_linkedList(){
         for (int i = 0; i < table.length; i++) {
            table[i]=new LinkedList<Node>();
         }
       }
    

       private int find_hash(K key){
            return Math.abs(key.hashCode())%initial_capacity;
       }
       private int check_in_linkedList(LinkedList<Node> list,K key){
          for (int i = 0; i < list.size(); i++) {
               if (list.get(i).key==key) {
                  return i;
               }
           }
           return -1;
       }

       
       public void put(K key, V val){
          int indx=find_hash(key);
         //  System.out.println(indx);
          LinkedList<Node> ll=null;
          Node newnode=new Node(key,val);
          if (entries==0) {
             initzialize_table(initial_capacity);
               ll=table[indx];
               ll.add(newnode); 
               entries++;
         }
         else{
            ll=table[indx];
            int ch=check_in_linkedList(ll, key);
            if (ch==-1) { 
               ll.add(newnode);
               entries++;
            }
            else{
               ll.add(ch,newnode);
            }

          }
       }

       public V remove(K key){
         int tabind=find_hash(key);
         LinkedList<Node> ll=table[tabind];
         int ch=check_in_linkedList(ll, key);
         if (ch==-1) {
            return null;
         }
         else{
            V val=ll.get(ch).value;
            ll.remove(ch);
            return val;
         }
       }


       public V get(K key){
         int table_indx=find_hash(key);
         LinkedList<Node> ll=table[table_indx];
         int indx=check_in_linkedList(ll, key);
         if (indx>=0) {
            return ll.get(indx).value;
         }
         return null; 
       }

       public boolean containsKey(K key){
          int tabind=find_hash(key);
          LinkedList<Node> ll=table[tabind];
          int ch=check_in_linkedList(ll, key);
          if (ch==-1) {
            return false;
          }
          else{
            return true;
          }
       }
       
       public int Size(){
         return entries;
       }


    }
    public static void main(String[] args) {
        MyHashMap<Integer,String> hh=new MyHashMap<>();
        hh.put(01,"umair");
        hh.put(04,"jatt");
        System.out.println(hh.Size());
        hh.put(32343,"hello");
        System.out.println(hh.Size());
      //  System.out.println(hh.containsKey(04));
      //   hh.put(01,"jatt");
      //   System.out.println(hh.get(01));
      //   hh.put(02, "Raza");
      //   System.out.println(hh.get(01));
    }
}
