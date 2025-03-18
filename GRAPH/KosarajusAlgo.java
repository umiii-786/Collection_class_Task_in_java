import java.util.ArrayList;
import java.util.Stack;
public class KosarajusAlgo {

  /*   strongly connected component: in graph the component is said to be strongly connected
    there is path exist from any node to any node in the component.*/
    // kosarajus's algorithm is use to find the SSC 

    static class Edge{
         int src;
         int dest;

         Edge(int s,int d){
            this.src=s;
            this.dest=d;
         }
    }
    public static void CreateGraph(ArrayList<Edge> graph []){
         for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
         }

         graph[0].add(new Edge(0, 2));
         graph[0].add(new Edge(0, 3));
         graph[1].add(new Edge(1, 0));
         graph[2].add(new Edge(2, 1));
         graph[3].add(new Edge(3, 4));
    }

    public static void DFS(ArrayList<Edge> graph [],boolean visited[],int src){
        if (!visited[src]) {
            visited[src]=true;
            System.out.print(src+"   ");
            for (int i = 0; i <graph[src].size(); i++) {
                Edge eg=graph[src].get(i);
                if (!visited[eg.dest]) {
                    DFS(graph, visited, eg.dest);
                }
            }
        }
    }
    public static void topologicalSorting(Stack<Integer> st,ArrayList<Edge> graph[],int src,boolean visited[]){
        if (!visited[src]) {
            visited[src]=true;
            for (int i = 0; i <graph[src].size(); i++) {
                Edge eg=graph[src].get(i);
                if (!visited[eg.dest]) {
                    topologicalSorting(st, graph, eg.dest, visited);
                }
            }
            st.push(src);
        }

    }
    public static void KosarajusAlgoImplement(ArrayList<Edge> graph[],boolean visited[]){
        Stack<Integer> st=new Stack<>();
        topologicalSorting(st, graph, 0, visited);
        int v=graph.length;
        ArrayList<Edge> transgraph[]=new ArrayList[v];

        for (int i = 0; i < v; i++) {
            transgraph[i]=new ArrayList<>();
        }
        for (int i = 0; i <v ; i++) {
            for (int j = 0; j <graph[i].size(); j++) {
                Edge eg=graph[i].get(j);
                transgraph[eg.dest].add(new Edge(eg.dest, eg.src)); 
            } 
        }
        boolean newvisisted[]=new boolean[v];
        while (st.size()>0) { 
            int s=st.pop();
            DFS(transgraph, newvisisted,s ); 
            System.out.println("\n");      
        }
    }

    
    public static void main(String[] args) {
        ArrayList<Edge> graph[]=new ArrayList[5];
        CreateGraph(graph);
        boolean visited[]=new boolean[graph.length];
        KosarajusAlgoImplement(graph,visited);
      
        
    }
}
