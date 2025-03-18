import java.util.HashMap;
import java.util.Map;

public class FindFrequency_using_Hash {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        int arrv=0;
        Map<Integer,Integer> mp=new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (mp.containsKey(arr[i])) {
                int val=mp.get(arr[i]);
                arrv=arr[i];
                mp.put(arr[i],val+1);
            }
            else{
                mp.put(arr[i],1);
            }
        }
        int max=0;
        for (int freq: mp.values()) {
            if (max<freq) {
                max=freq;
            }
        }
        System.out.println(arrv+"  have the "+max);
    }
}
