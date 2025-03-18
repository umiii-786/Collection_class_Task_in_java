import java.util.ArrayList;
import java.util.PriorityQueue;

public class FamousAlogrithm {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
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
        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static void DFS(ArrayList<Edge> graph[], boolean visited[], int src) {
        System.out.print(src + "     ");
        visited[src] = true;
        for (int i = 0; i < graph[src].size(); i++) {
            Edge eg = graph[src].get(i);
            if (!visited[eg.dest]) {
                DFS(graph, visited, eg.dest);
            }
        }
    }

    static class Pair implements Comparable<Pair> {
        int node;
        int wt;

        Pair(int n, int w) {
            this.node = n;
            this.wt = w;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.wt - p2.wt;
        }
    }

    public static void DijkstrasPractices(ArrayList<Edge> [] graph, int src) {
          PriorityQueue<Pair> pq=new PriorityQueue<>();
          boolean visited[]=new boolean[6];
          int dist[]=new int[6];
          for (int i = 0; i < dist.length; i++) {
               if (i!=src) {
                   dist[i]=Integer.MAX_VALUE;
               }
          }

          pq.add(new Pair(src,src));
          while (pq.size()>0) {
               Pair p=pq.remove();
               if (!visited[p.node]) {
                    for (int i = 0; i <graph[p.node].size(); i++) {
                        Edge eg=graph[p.node].get(i);
                        int u=eg.src;
                        int v=eg.dest;
                        int wt=eg.wt;
                        if (dist[u]+wt<dist[v]) {
                            dist[v]=dist[u]+wt;
                            pq.add(new Pair(v, dist[v]));
                        }
                    }
               }
          }

          for (int i : dist) {
            System.out.print(i+"   ");
          }
    }

    // the time complexity of Dijkstras algroithms is O(E+ElogV)
    // in which ElogV is the complexity of priority queue for sorting the algorithm
    public static void Dijkstras(ArrayList<Edge>[] graph, int start, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int dist[] = new int[V];
        for (int i = 0; i < dist.length; i++) {
            if (i != start) {
                dist[i] = Integer.MAX_VALUE;
            }
        }
        boolean visited[] = new boolean[V];

        pq.add(new Pair(0, 0));
        while (pq.size() > 0) {
            Pair S_Path_Nodes = pq.remove();
            if (!visited[S_Path_Nodes.node]) {
                visited[S_Path_Nodes.node] = true;

                for (int i = 0; i < graph[S_Path_Nodes.node].size(); i++) {
                    Edge node = graph[S_Path_Nodes.node].get(i);
                    int u = node.src;
                    int v = node.dest;
                    if (dist[v] > dist[u] + node.wt) {
                        dist[v] = dist[u] + node.wt;
                        pq.add(new Pair(node.dest, dist[v]));
                    }

                }

            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + "    ");
        }

    }


    public static void BellmonFordAlogrithm(ArrayList<Edge> graph[],int src,int v){
         int dist[]=new int[v];
         for (int i = 0; i < dist.length; i++) {
            if (i!=src) {
                dist[i]=Integer.MAX_VALUE;
            }
         }

         for (int i = 0; i < v-1; i++) {
            for (int j = 0; j <v; j++) {
                for (int k = 0; k <graph[j].size(); k++) {
                    Edge eg=graph[j].get(k);
                    int u=eg.src;
                    int V=eg.dest;
                    if (dist[u]!=Integer.MAX_VALUE && dist[u]+eg.wt<dist[V]) {
                        dist[V]=dist[u]+eg.wt;
                    }
                }
            }
         }
         System.out.println();
         for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i]+"    ");
         }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        CreateGraph(graph);
        boolean visited[] = new boolean[v];

        Dijkstras(graph, 0, v);
        BellmonFordAlogrithm(graph, 0, v);

        // for (int i = 0; i <visited.length; i++) {
        // if (!visited[i]) {
        // System.out.println("chala");
        // DFS(graph, visited, i);
        // }
        // }

    }
}
