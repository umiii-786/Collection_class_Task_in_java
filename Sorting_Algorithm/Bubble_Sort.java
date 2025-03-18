public class Bubble_Sort{

    public static void BubbleSort(int arr[]){
        int n=arr.length;
        System.out.println(n);

        for (int i = 0; i <n; i++) {
            for(int j=0;j<n-i-1;j++){
                if (arr[j]>arr[j+1]) {
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
                // System.out.print("hn");
            }
            // System.out.println("hello");
        }

    }
    public static void main(String[] args) {
        int arr[]={2445,787,891,18,899,990,1,678};
        System.out.println("Element of Array before Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");
        BubbleSort(arr);
        System.out.println("Element of Array After Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");

    }
}