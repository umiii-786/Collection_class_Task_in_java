import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KhanAlgo {
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 4));
       
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 1));

        graph[5].add(new Edge(5,1));
        graph[5].add(new Edge(5, 4));

    }

    public static void bfs(ArrayList<Edge> []graph,boolean visited[],int s){

         Queue<Integer> node=new LinkedList<>(); 
         node.add(s);
         while (node.size()>0) {
              int src=node.remove();
              if (!visited[src]) {
                 visited[src]=true;
                 System.out.print(src+"   ");
                 for (int i = 0; i < graph[src].size(); i++) {
                    Edge eg= graph[src].get(i);
                    if (!visited[eg.dest]) {
                       node.add(eg.dest); 
                    }
                 }
              }
         }

    }
    public static void KhansAlgo_usingBfs_Topological(ArrayList<Edge> graph[]){
        int indegree[]=new int[graph.length];
         for (int i = 0; i <graph.length; i++) {
             for (int j = 0; j < graph[i].size(); j++) {
                Edge eg=graph[i].get(j);
                 indegree[eg.dest]++;
             }
         }
         Queue<Integer> q=new LinkedList<>();
         for (int i = 0; i < indegree.length; i++) {
            if (indegree[i]==0) {
                q.add(i);
            }
         }

         while (q.size()>0) {
            int node=q.remove();
            System.out.print(node+"    ");
            for (int i = 0; i < graph[node].size(); i++) {
                Edge eg=graph[node].get(i);
                if(--indegree[eg.dest]==0){
                    q.add(eg.dest);
                }
            }
          
         }
    }

    public static void makeFriend(){

    }
    public static void AreFriend(){
      
    }

    
    public static void main(String[] args) {
        ArrayList<Edge>[] graph=new ArrayList[6];
        createGraph(graph);
        boolean[] visited=new boolean[graph.length];
        // System.out.println(visited.length);
        KhansAlgo_usingBfs_Topological(graph);
      
    }
}
