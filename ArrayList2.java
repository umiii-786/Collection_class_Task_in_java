import java.util.*;

public class ArrayList2 {
    public static void main(String[] args) {
        int k=1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(34);
        list.add(4);
        list.add(56);
        list.add(23);
        list.add(227);
        list.add(2);
        list.add(14);
        list.add(340);

        // System.out.println(list);
        // for(int i=0;i<list.size()-1;i++){
        //     for(int j=k;j<list.size();j++){
        //          if(list.get(i)>list.get(j)){
        //            int greater=list.get(j);
        //           int small=list.get(j);
        //            list.set(j,greater);
        //            list.set(i, small);
        //          }
        //          k++;
        //         }
        // }
        System.out.println(list);
        
        Collections.sort(list);
        System.out.println(list);
        // list.removeAll(list);
        System.out.println(list);



        System.out.println(list.subList(2, 6));

    }
}