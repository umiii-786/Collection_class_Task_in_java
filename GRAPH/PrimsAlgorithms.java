import java.util.ArrayList;
import java.util.PriorityQueue;

public class PrimsAlgorithms {

    static class Edge{
        int src;
        int dest;
        int wt;

        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    public static void CreateGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[2].add(new Edge(2, 1, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    static class Pair implements Comparable<Pair>{
        int src;
        int node;
        int cost;

        Pair(int src,int node,int cost){
          this.src=src;
          this.node=node;
          this.cost=cost;
        }
        @Override
        public int compareTo(Pair pr2) {
            return this.cost-pr2.cost;
        }
     
    }
    public static void FindMST(ArrayList<Edge> graph[]){
        PriorityQueue<Pair> pq=new PriorityQueue<>();

        boolean visited[]=new boolean[graph.length];
        pq.add(new Pair(0,0,0));
        int mincost=0;
        ArrayList<Edge> Mstedges=new ArrayList<>();
        while (pq.size()>0) {
           Pair p=pq.remove();

           if (!visited[p.node]) {
             visited[p.node]=true;
              if (p.node!=0) {
                Mstedges.add(new Edge(p.src,p.node,p.cost));
                mincost+=p.cost;
              }
              for (int i = 0; i < graph[p.node].size(); i++) {
                Edge eg=graph[p.node].get(i);
                if (!visited[eg.dest]) {
                    pq.add(new Pair(p.node,eg.dest,eg.wt));
                }
             }
           }      
        }

        System.out.println("minimum weight of spanning tree is "+mincost);
    }

    public static void main(String[] args) {
          
        ArrayList<Edge> graph[]=new ArrayList[4];
        CreateGraph(graph);
        FindMST(graph);


        
    }
}
