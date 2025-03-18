import java.util.Stack;

class MyQueue {
    Stack<Integer> real=new Stack<>();
    Stack<Integer> helper=new Stack<>();
    
    public MyQueue() {
        
    }
    
    public void push(int x) {  
        if(helper.size()==0){
            helper.push(x);
            return;
        }
        

            while(helper.size()>0){
                real.push(helper.pop());
            }
            real.push(x);
            while(real.size()>0){
                helper.push(real.pop());
            }
            System.out.println(helper);
       
    }
    
    public int pop() {
        if(helper.size()==0){
            return -1;
        }
        return helper.pop();
    }
    
    public int peek() {
        if(helper.size()==0){
            return -1;
        }
        int val=helper.peek();
          return val;
    }
    
    public boolean empty() {
        if(helper.size()==0) return true;
        else return false;
    }
    public void display(){
        System.out.println(helper);
    }
}


public class Queues_using_stack {
    public static void main(String[] args) {
        MyQueue q=new MyQueue();
        q.push(0);
        q.push(44);
        q.display();
        System.out.println(q.pop());

    }
}
