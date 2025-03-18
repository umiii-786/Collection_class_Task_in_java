import java.util.ArrayList;
import java.util.Scanner;

public class LinearProbing {
    static int hash(String data){
        return  Math.abs(data.hashCode()%7);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] table=new String[7];
        for(int i=0;i<5;i++){
            String data=sc.nextLine();
            int indx=hash(data);
            System.out.println("real tab  indx "+indx);
            while ( indx<7  && table[indx]!=null) {
                 System.out.println("aviable ");
                 indx++;
            }
            System.out.println("after checking element in table  then indx is "+indx);
            if(indx<7){
                table[indx]=data;
                System.out.println("hoya add ");
            }
            else{

            }
            System.out.println(indx);
    }


    String finddata="umair";
    int findx=hash(finddata);
    while (table[findx]!=finddata) {
        findx++;
    }
    System.out.println("umair is present in tables is "+table[findx]);





        

        
    }
}
