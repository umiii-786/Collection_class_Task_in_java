import java.util.ArrayList;

public class AgainPractice_by_implementation {
    class Edge{
        int src;
        int dest;
        
    }

    public void printAllPath(ArrayList<Edge> graph [],int src,int tar, String path,boolean visited[]){
         
     
        for (int i = 0; i < graph[src].size(); i++) {
            Edge eg=graph[src].get(i);
            if (src==tar) {
                System.out.println(path);
                return;
            }
            if (!visited[eg.dest]) {
                visited[src]=true;
                printAllPath(graph, eg.dest, tar, path+eg.dest, visited);
                visited[src]=false;
            }
        }
    }
  public static void main(String[] args) {
    
  }   
}
