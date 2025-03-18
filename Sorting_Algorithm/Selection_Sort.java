public class Selection_Sort {

    public static void SelectionSort(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]) {
                    int temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
          
        }
    }
    public static void main(String[] args) {
        int arr[]={32,12,44,767,89,21,121,13,11};
        System.out.println("Element of Array before Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");
        SelectionSort(arr);
        System.out.println("Element of Array After Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");

    }
}
