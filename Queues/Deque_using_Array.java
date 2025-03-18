public class Deque_using_Array {
    int arr[]=new int[10];
    int top=-1;
    int last=-1;
    int size=0;
    public void addFirst(int val){
        if (size==0) {
            arr[++top]=val;
            last++;
            size++;
        }
      
    }
    public static void main(String[] args) {
        
    }
}
