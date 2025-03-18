import java.util.Stack;
public class Celebrity {
    public static int Celebrity_calulate(){
        int party[][]={
            {0,0,0},
            {1,0,0},
            {1,0,0} };

        Stack<Integer> value=new Stack<>();
        for (int i = 0; i < party.length; i++) {
            value.push(i);
        }

        while (value.size()>1) {
            int p2=value.pop();
            int p1=value.pop();

            if (party[p2][p1]==0) { 
                value.push(p2);
            }
            else if (party[p1][p2]==0) {
                value.push(p1);
            }
        }
        if (value.size()==0) return -1;

        int priority=value.pop();
        System.out.println(priority);
        for (int i = 0; i < party.length; i++) {
            if (i==priority){
                continue;
            }
            if (party[priority][i]!=0) {
                return -1;
            }
        }
        for (int j = 0; j < party.length; j++) {
            if (priority==j){
                continue;
            }
            if (party[j][priority]!=1){
                return -1;
            }
        }

        return priority;

        }

    public static void main(String[] args) {
       System.out.println( Celebrity_calulate());
    }
}
