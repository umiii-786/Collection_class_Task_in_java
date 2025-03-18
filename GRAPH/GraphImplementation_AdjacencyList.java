import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphImplementation_AdjacencyList {
    static class Edge{
        int src;
        int dest;
        // int wt;

        Edge(int s,int d){
            this.src=s;
            this.dest=d;
            // this.wt=w;
        }
    }
    static public void CreateGraph(ArrayList<Edge>[] graph){
        for (int i = 0; i < graph.length; i++) {
            graph[i]=new ArrayList<>();
        }




        // graph 4
        // graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));

        // graph[4].add(new Edge(4, 0));
        // graph[4].add(new Edge(4, 1));

        // graph[5].add(new Edge(5, 0));
        // graph[5].add(new Edge(5, 2));
















        // graph 3
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 3));
        // graph[2].add(new Edge(2, 3));

        // graph 2 
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));


        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 4));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 3));


        graph[3].add(new Edge(3, 2));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 1));








         //   graph 1
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        // // graph[0].add(new Edge(0,3));

        // graph[1].add(new Edge(1,0));
        // graph[1].add(new Edge(1,3));

        // // graph[1].add(new Edge(1,4));s
        // graph[2].add(new Edge(2,0));
        // graph[2].add(new Edge(2,4));
        // // graph[2].add(new Edge(2,3));

        // graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,4));
        // graph[3].add(new Edge(3,5));

        // graph[4].add(new Edge(4,2));
        // graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));


        // graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));
        // graph[5].add(new Edge(5,6));

        // graph[6].add(new Edge(6,5));

        // System.out.println("hello wrold");
    }

    // time complexity to find the Neighbour in Adjacency list is O(x) where x is the number of neighbour
    static public void PrintNeighbour(ArrayList<Edge>[] graph, int vertex){
            for (int i = 0; i < graph[vertex].size(); i++) {
                Edge ed=graph[vertex].get(i);
                System.out.println(ed.dest);
            }
            System.out.println("\n");
    }


    // time complexity is O(V+E)  if E is greate then V so we consisdered O(E) viceversa
    static void BreathFirstTraversal(ArrayList<Edge> graph[]){
         boolean visited[]=new boolean[graph.length];
         Queue<Integer> neighbour=new LinkedList<>();
         neighbour.add(graph[0].get(0).src);

         for (int i = 0; i < graph.length; i++) {
            while(visited[neighbour.peek()]){
                neighbour.remove();    
            }
            int qvalues =neighbour.remove();
            System.out.print(qvalues+"  ");
            visited[qvalues]=true;
            for (int j = 0; j <graph[qvalues].size(); j++) {
                neighbour.add(graph[qvalues].get(j).dest); 
            }
             System.out.println(neighbour);

            } 
    }


    // the time complexity of DFS is also O(V+E) 
    public static void Find_All_Path(ArrayList<Edge>[] graph,int src,int tar,boolean visited[],String Path){
        if (src==tar) {
            System.out.println(" path is " +Path);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            int sr=graph[src].get(i).dest;
            if (visited[sr]==false) {
                visited[src]=true;   
                Find_All_Path(graph, sr, tar, visited, Path+sr);
                visited[src]=false;
            } 
        }
        
    }


    public static void DFS(ArrayList<Edge> []graph,boolean []visited,int first){
        if (visited[first]) {
            return;
        }
        System.out.print(first+"     ");
        visited[first]=true;
        for (int i = 0; i < graph[first].size(); i++) {
            DFS(graph, visited,graph[first].get(i).dest);
        }
    }


    public static void Method2_BFS(ArrayList<Edge> [] graph,boolean visited[],int start){
        Queue<Integer> neighbour=new LinkedList<>();
        
        neighbour.add(start);
        while (neighbour.size()>0) {
            int val=neighbour.remove();
            if (visited[val]==false) {
                System.out.print(val+"   ");
                visited[val]=true;
                for (int i = 0; i < graph[val].size(); i++) {
                    neighbour.add(graph[val].get(i).dest);   
                }
            }

        }

    }

    public static boolean Detect_Cycle_In_Undirected_Graph(ArrayList<Edge> graph[],int src,int parent,boolean visited[]){
        visited[src]=true;
        for (int i = 0; i <graph[src].size(); i++) {
            Edge eg=graph[src].get(i);
            if (visited[eg.dest]==true && parent!=eg.dest) {
                return true;
            }
            if (visited[eg.dest]!=true) {
                Detect_Cycle_In_Undirected_Graph(graph, eg.dest, src, visited);    
            }            
        }

        return false;

    }

    // // time complexity of Detect_Cycle_In_Undirected_Graph is O(V+E)
    // public static boolean Detect_Cycle_In_Undirected_Graph(ArrayList<Edge>[] graph,boolean visited[],int parent,int src){
    //           if (visited[src]==true) {
    //             //    System.out.println("cycle is present ");
    //                return true;
    //           }
    //           visited[src]=true;
    //           boolean check=false;
    //           for (int i = 0; i < graph[src].size(); i++) {
    //               Edge ed=graph[src].get(i);
    //               if (ed.dest!=parent) {
    //                 check=Detect_Cycle_In_Undirected_Graph(graph, visited, src, ed.dest);
    //               }
    //           }
    //           return check;
    // }

     static class pair{
        int vertex;
        int parent;
        pair(int v,int p){
            this.vertex=v;
            this.parent=p;
        }
    }
    public static void Detect_Cycle_In_UnDirected_Graph_Using_BFS(ArrayList<Edge>[] graph){
        Queue<pair> q=new LinkedList<>();
        boolean [] visited=new boolean[graph.length];
        q.add(new pair(0, -1));
        
        while (q.size()>0) {
            pair p=q.remove();
            visited[p.vertex]=true;
            for (int i = 0; i < graph[p.vertex].size(); i++) {
                Edge eg=graph[p.vertex].get(i);
                  if (visited[eg.dest]) {
                    if (eg.dest==p.parent) {
                        System.out.println("cycle is present");
                        break;
                    }
                      
                  }
                  else{
                      q.add(new pair(eg.dest, p.vertex));   
                  }
            }
        }


    }

    public static boolean Detect_Cycle_In_Directed_Graph(ArrayList<Edge>[] graph,boolean visited[],boolean []recursiveStack,int src){
         recursiveStack[src]=true;
         visited[src]=true;
          boolean ch=false;  
         for (int i = 0; i < graph[src].size(); i++) {
             Edge eg=graph[src].get(i);
             if (recursiveStack[eg.dest]==true) {
                return true;
             }
             else if (!visited[eg.dest]) {
                 ch=Detect_Cycle_In_Directed_Graph(graph, visited, recursiveStack, eg.dest);
             }
         }
         recursiveStack[src]=false;
         return ch;

    }

    public static void topologicalSeries(Stack<Integer> st,ArrayList<Edge> []graph,boolean visited[],int curr){
        visited[curr]=true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge eg=graph[curr].get(i);
            if (visited[eg.dest]==false) {
                topologicalSeries(st, graph, visited,eg.dest);
            }
        }
        st.push(curr);
    }


 
    public static void main(String[] args) {
        int v=5;
        ArrayList<Edge> [] graph=new ArrayList[v];
        CreateGraph(graph); 
        boolean visied[]=new boolean[v] ;
        Stack<Integer> st=new Stack<>();
        topologicalSeries(st, graph, visied, 0);
         while (st.size()>0) {
            System.out.print(st.pop()+"    ");
         }
        //    System.out.println(Detect_Cycle_In_Undirected_Graph(graph, 0, 0, visied));
        // Find_All_Path(graph, 0,3,visied, 1);
        // Detect_Cycle_In_UnDirected_Graph_Using_BFS(graph);





        // PrintNeighbour(graph,2);  
        // boolean visited[]= new boolean[graph.length]; 
        //  for (int i = 0; i < v; i++) {
        //     if (visited[i]==false) {
        //         DFS(graph, visited, i);  
        //     }
        // }





        // for (int i = 0; i < visited.length; i++) {
        //     if (visited[i]==false) {
        //         DFS(graph, visited, i);
        //     }
        // }


        // Find_All_Path(graph,0,5,visited,"0");
        // boolean check=false;
        // for (int i = 0; i < v; i++) {
        //     if(visited[i]==false){
        //         if(Detect_Cycle_In_Directed_Graph(graph,visited,new boolean[v], i)) {
        //             System.out.println("hello true");
        //             check=true;
        //             break;
        //         }
        //     }
        // }
        // System.out.println(check);





        // Stack<Integer> st=new Stack<>();
        // for (int i = 0; i <v; i++) {
        //     if (visited[i]==false) {
        //         topologicalSeries(st,graph,visited,i);
        //     }
        // }

        // int size=st.size();
        // for (int i = 0; i < size; i++) {
        //     System.out.print(st.pop()+"    ");
        // }
    }
}