public class Circular_Queues_by_ARRAY2 {
    int arr[]=new int[10];
    int top=-1;
    int last=-1;
    int size=0;
    public void push(int val){
        if (size==0) {
            arr[++top]=val;
            System.out.println("hi");
            last++;
            size++;
            return;
        }

        if (size==arr.length) {
            System.out.println("queues is fulll ");
            return;
        }
        if (top!=0 && last==arr.length-1) {
            System.out.println(" i am seeing ");
            arr[0]=val;
            last=0;
            size++;
            return;
        }
        arr[++last]=val;
        size++;

    }

    public int remove(){
        if (top==arr.length-1) {
            int val=arr[top];
            size--;
            top=0;
            return top;
        }
        if (size==0) {
            System.out.println("queues is empty ");
            return -1;
        }
        int val=arr[top];
        size--;
        top++;
        return val;
    }

    public int peek(){
        return arr[top];
    }

    public void display() {
      
        if (last<top) {
            for (int i =top; i<arr.length; i++) {
            System.out.print(arr[i]+" , ");
           }
           for (int i = 0; i <=last; i++) {
            System.out.print(arr[i]+" , ");
           }
           
        }
        else{
            for (int i =top; i <=last; i++) {
                System.out.print(arr[i]+" , ");
            }
        }
        System.out.println("\n");
    }


    
    public static void main(String[] args) {
        Circular_Queues_by_ARRAY2 q=new Circular_Queues_by_ARRAY2();
        q.push(45);
        q.push(54);
        q.push(6);
        q.push(11);
        q.push(6576);
        q.push(5678);
        q.push(676543);
        q.push(8765);
        q.push(111212122);
        q.push(565656);
        q.display();

        q.remove();
         q.remove();
          q.remove();
        q.display();
        q.push(110404);
        q.push(4343);
        q.display();
        q.remove();
        q.remove();
        q.display();
        q.push(14);
        q.remove();
        q.remove();
        q.remove();
        q.display();
        q.remove();
        q.display();
        q.remove();
        q.display();
        q.push(334545);
        q.push(454656);
        q.display();
        // System.out.println(q.size);
        // q.push(23);
        // q.display();
    //    System.out.println(q.remove());
    //    q.display();


    }
}
