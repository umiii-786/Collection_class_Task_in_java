import java.util.ArrayList;

public class Graph2_imple_by_self {
    static class neighbour {
        String name;
        int km;

        neighbour(String n,int k){
            this.name=n;
            this.km=k;
        }  
    }
    static public void createGraph(int graph[][]){
        graph[0][0]=0;
        graph[0][1]=1;
        graph[0][2]=0;
        graph[0][3]=1;



        graph[1][0]=1;
        graph[1][1]=0;
        graph[1][2]=1;
        graph[1][3]=1;

        graph[2][0]=0;
        graph[2][1]=1;
        graph[2][2]=0;
        graph[2][3]=1;



        graph[3][0]=1;
        graph[3][1]=1;
        graph[3][2]=1;
        graph[3][3]=0;
    }

    static public void neighbour(int graph[][],int vertex){
        System.out.println("neighbour of "+vertex+"  vertex is \n");
         for (int i = 0; i < graph[vertex].length; i++) {
             if (graph[vertex][i]==0) {
                
             }
             else{
                System.out.print(i+"      ");
             }
         }
    }
    public static void main(String[] args) {
        
          int vertexes=7;
          int graph[][]=new int[4][4];
          createGraph(graph);
          neighbour(graph, 1);



    }
}
