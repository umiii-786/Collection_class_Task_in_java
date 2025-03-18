public class Insertion_Sort {
    public static void InsertionSort(int arr[]){
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j>=0; j--) {
                if (arr[j]<arr[j-1]) {
                    int temp=arr[j];
                    arr[j]=arr[j-1];
                    arr[j-1]=temp;
                }
                else{
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int arr[]={3,565,671,11,43,781,15,13,17};
        System.out.println("Element of Array before Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");
        InsertionSort(arr);
        System.out.println("Element of Array After Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");

    }
}
