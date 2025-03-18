import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        System.out.print("enter the number you want to check in array :");
        int check=sc.nextInt(); 
        int first=0;
        int last=arr.length-1;
        while (first<=last) {
            int mid=(first+last)/2;
            System.out.println(mid+"   ");
            if (arr[mid]==check) {
                System.out.println("element is found at index"+mid);
                break;
            }
            if (check>arr[mid]) {
                first=mid+1;
            }
            else if (check<arr[mid]) {
                last=mid-1;
            }
        }

        if (first>last) {
            System.out.println("element is not avaiable in array ");
        }
    }
}