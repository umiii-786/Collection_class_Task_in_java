public class Queues_by_Array {
    private int arr[]=new int[10];
    int pointer=9;
    int top=9;
    int size=0;

    public void add(int val){
        if (size==0) {
            arr[pointer]=val;
            size++;
            return;
        }
        arr[--pointer]=val;
        size++;
    }
    public int peek(){
        return arr[top];
    }
    public int remove(){
        int val=arr[top];
        top--;
        size--;
        return val;
    }

    public void display(){
        int i=0;
        int temp=top;
        while (true) {
            if (i==size) {
                break;
            }
            System.out.print(arr[temp--]+"  ,  ");
            i++;
        }
        // for(int i=top;i>arr.length-size;i++){
        //     System.out.print(arr[]);
        // }
       
    }

    public static void main(String[] args) {
        Queues_by_Array q=new Queues_by_Array();
        q.add(345);
        q.add(7667);
        q.add(1);
        q.display();
        System.out.println("\n");
        System.out.println(q.remove());
        q.display();
    }
}
