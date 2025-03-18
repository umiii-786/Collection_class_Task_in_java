import java.util.LinkedList;

public class Implementing_Hashmap_with_remove_collision {

    static class HashMap<K, V> {

        class Node {
            K key;
            V value;

            Node(K ke, V val) {
                this.key = ke;
                this.value = val;
            } 
        }

        private double initial_capacity = 4;
        private double Load_factor = 0.75;
        private LinkedList<Node> Table[];
        private int entries = 0;

        private int find_hash(K key) {
            return (int)(Math.abs(key.hashCode()) % initial_capacity);
        }

        private int check_in_linkedList(LinkedList<Node> list,K key){
            for(int i=0;i<list.size();i++){
                if (key==list.get(i).key) {
                    System.out.println("hoya cheeck");
                    return i;
                }
            }
            return -1;
        }

        private LinkedList<Node>[] initzialize_table(int initial_capacity) {
            return new LinkedList[initial_capacity];   
        }
        private void initzialize_linkedList(LinkedList<Node> tb[]){
            for (int i = 0; i < tb.length; i++) {
                tb[i]=new LinkedList<>();
            }
        }
        private LinkedList<Node>[] copying_One_table_to_another_table(LinkedList<Node> NT[]){
            LinkedList<Node> ll;
            for (int i = 0; i < Table.length; i++) {
                ll=Table[i];
                for (int j = 0; j <ll.size(); j++) {
                    K k=ll.get(j).key;
                    int new_tab_ind=find_hash(k);
                    LinkedList<Node> new_table_LL=NT[new_tab_ind];
                    new_table_LL.add(ll.get(j));
                }
            }

            return NT;
        }

        public void put(K key, V value) {

            int table_indx=find_hash(key); 
            // System.out.println(table_indx+" is hash val of "+key);
            LinkedList<Node> ll=null;
            double ld_fac=entries / initial_capacity; 
            // System.out.println(ld_fac);
            if (ld_fac == Load_factor) {
                System.out.println("axha");
                initial_capacity=initial_capacity*2;
                LinkedList<Node> newtable[]=initzialize_table((int)initial_capacity);
                initzialize_linkedList(newtable);
                Table=copying_One_table_to_another_table(newtable); 
                ll=Table[table_indx];
                Node newnNode=new Node(key, value);
                ll.add(newnNode);
                entries++;
            }


           else{  
               if (entries==0) {
                   Node newNode=new Node(key,value);
                   Table=initzialize_table((int)initial_capacity);
                   initzialize_linkedList(Table);
                   ll=Table[table_indx];
                   ll.add(newNode);
                   System.out.println(ll);
                   entries++;
                }
                
                else{
                    ll=Table[table_indx];
                    int check=check_in_linkedList(ll, key);
                    if (check==-1) {
                        Node newnNode=new Node(key, value);
                        ll.add(newnNode);
                        entries++;
                    }
                    else{
                        System.out.println("checkkign ");
                       ll.get(check).value=value;
                    }
               }

            }
            

        }
        public int Size(){
            return entries;
        }
        public void display(){
            for (int i = 0; i < Table.length; i++) {
                LinkedList<Node> ll=Table[i];
                if (ll.size()==0) {
                    continue;
                }
                for (int j = 0; j < ll.size(); j++) {
                    System.out.println(ll.get(j).key+" ---> "+ll.get(j).value);
                }
            }
        }

        public V remove(K key){
           int tab_ind=find_hash(key);
           LinkedList<Node> ll=Table[tab_ind];
           int ch=check_in_linkedList(ll, key);
           if (ch==-1) {
              return null;
           }
          V val=ll.get(ch).value;
          ll.remove(ch);
          entries--;

           return val;
        }

    }

    public static void main(String[] args) {
        HashMap<Integer,String> mp=new HashMap<>();
        // System.out.println(3.0/4.0);
        mp.put(4556,"hello");
        mp.put(43, "umiii");
        mp.put(334,"axha");
    
        System.out.println("Size is "+mp.Size());
        // System.out.println("size is "+mp.Size());
        mp.display();

    }
}