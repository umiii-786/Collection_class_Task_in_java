public class Merge_Sort {
  
    public static void Divide(int arr[],int first,int last){
        if (first>=last) {
            return;
        }
        int mid=first+(last-first)/2;
        Divide(arr, first, mid);
        Divide(arr, mid+1, last);
        conquere(arr, first, mid, last);
         
    }
    public static void conquere(int arr[],int first,int mid,int last){
          int MergedArray[]=new int[last-first+1];
          int Array1Indx=first;
          int Array2Indx=mid+1;
          int mergeindx=0;
   
          while (Array1Indx<=mid && Array2Indx<=last) {
            if (arr[Array1Indx]<=arr[Array2Indx]) {
                MergedArray[mergeindx]=arr[Array1Indx];
                Array1Indx++;
                mergeindx++;
            }
            else{
                MergedArray[mergeindx]=arr[Array2Indx];
                Array2Indx++;
                mergeindx++;
            }  
          }

          while (Array1Indx<=mid) {
            MergedArray[mergeindx++]=arr[Array1Indx++];
          }
          while (Array2Indx<=last) {
            MergedArray[mergeindx++]=arr[Array2Indx++];
          }
          for (int i = 0,j=first; i < MergedArray.length;j++,i++) {
              arr[j]=MergedArray[i];
          }
    }
    public static void main(String[] args) {
        int arr[]={44,6,8789,255,989,632,1,34,2};
        System.out.println("Element of Array before Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");
        Divide(arr, 0, arr.length-1);
        System.out.println("Element of Array After Sort are ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"   ");
        }
        System.out.println("\n");

    }
}
