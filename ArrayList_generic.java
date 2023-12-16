import java.util.ArrayList;


class MyGeneric<Int,St>{
     private Int n;
     private St str;

    public Int getN() {
        return n;
    }

    public void setN(Int n) {
        this.n = n;
    }

    public St getStr() {
        return str;
    }

    public void setStr(St str) {
        this.str = str;
    }


}
public class ArrayList_generic {
    public static void main(String[] args) {
           
       MyGeneric<Integer,String> obj=new MyGeneric<>();
       obj.setN(235);
       obj.setStr("umaueutg");
       Integer num=obj.getN();
       String st=obj.getStr();

       System.out.println(num);
       System.out.println(st);    


    //     ArrayList<Integer> l=new ArrayList<>();
    //     l.add(23);
    //     l.add(454);
    //     l.add(121222);
    //     l.add(5876876);

    // for (Integer integer : l) {
    //     System.out.println(integer);
    // }


        // int n=(int) l.get(1);
        // System.out.println(n);
        // boolean name=(boolean)l.get(2);
        // System.out.println(name);
    //    for(int i=0;i<l.size();i++){
    //     System.out.println(l.get(i));
    //    }
    }
}
