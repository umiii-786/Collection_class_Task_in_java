import java.util.ArrayList;

public class TrajanAlgorithm {
    // this algorithm is basically use to find the bridge
    // (bridge is the edge in the graph if we remove it that
    // it increase the no of strongly connected component)
    static class Edge {
        int src;
        int dest;

        Edge(int s,int d) {
            this.src=s;
            this.dest=d;
        }
    }

    public static void createGraph(ArrayList<Edge> [] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));


        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));


        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));
        graph[4].add(new Edge(4,3));
    }

    public static void Trojanalgor(ArrayList<Edge> [] graph,boolean visited[],int parent,int src,int dt[],int low[],int time) {
       visited[src]=true;
       dt[src]=low[src]=++time;
       for (int i = 0; i < graph[src].size(); i++) {
          Edge eg=graph[src].get(i);
          if (eg.dest==parent) {
             continue;
          }
          else if (!visited[eg.dest]) {
              Trojanalgor(graph, visited, src, eg.dest, dt, low, time);
              low[src]=Math.min(low[src],low[eg.dest]);
              if (dt[src]<low[eg.dest]) {
                 System.out.println("Bridge is  "+src+"    "+eg.dest);
              }
                              
          }
          else{
            low[src]=Math.min(dt[src],low[eg.dest]);
          }
       }

    }
    public static void getBridge(ArrayList<Edge> [] graph,int v){
        int []dt=new int[v];
        int lowdt[]=new int[v];
        int time=0;
        boolean[] visited=new boolean[v];
        int parent=-1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                Trojanalgor(graph,visited,-1,i,dt,lowdt,time);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Edge> [] graph=new ArrayList[5];
        createGraph(graph);
        getBridge(graph, 5);

    }
}
