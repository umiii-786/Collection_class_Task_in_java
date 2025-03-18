
// import javafx.application.Application;
// import javafx.geometry.Insets;
// import javafx.scene.Scene;
// import javafx.scene.control.Button;
// import javafx.scene.layout.VBox;
// import javafx.stage.Stage;

// public class SchoolManagementSystem extends Application {
// // /
//     public static void main(String[] args) {
//         launch(args);
//     }

//     @Override
//     public void start(Stage primaryStage) {
//         primaryStage.setTitle("School Management System");

//         Button adminButton = new Button("Admin Login");
//         adminButton.setOnAction(e -> {
//             // Logic for handling admin login
//             System.out.println("Admin Login clicked");
//         });

//         Button studentButton = new Button("Student Login");
//         studentButton.setOnAction(e -> {
//             // Logic for handling student login
//             System.out.println("Student Login clicked");
//         });

//         VBox layout = new VBox(10);
//         layout.setPadding(new Insets(20, 20, 20, 20));
//         layout.getChildren().addAll(adminButton, studentButton);

//         Scene scene = new Scene(layout, 300, 200);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }
// }

















// // import java.util.ArrayList;
// // import java.util.LinkedList;
// // import java.util.Queue;
// // import java.util.Scanner;
// // public class check {
// //     static ArrayList<Character> vertices=new ArrayList<>();
// //     static class Edge {
// //          char src;
// //          char dest;
// //          Edge(char s,char d){
// //             this.src=s;
// //             this.dest=d;
// //          }
// //     }
// //     public static void CreateGraph(ArrayList<Edge> graph[]){
// //         for (int i = 0; i < graph.length; i++) {
// //             graph[i]=new ArrayList<>();
// //         }
// //         graph[0].add(new Edge('A', 'B'));
// //         graph[0].add(new Edge('A', 'C'));
// //         graph[0].add(new Edge('A', 'E'));
// //         graph[1].add(new Edge('B', 'A'));
// //         graph[1].add(new Edge('B', 'D'));
// //         graph[1].add(new Edge('B', 'F'));
// //         graph[2].add(new Edge('C', 'A'));
// //         graph[2].add(new Edge('C', 'G'));
// //         graph[3].add(new Edge('D', 'B'));
// //         graph[4].add(new Edge('E', 'A'));
// //         graph[4].add(new Edge('E', 'F'));
// //         graph[5].add(new Edge('G', 'C'));
// //     }

// //     public static void findAdjacent(ArrayList<Edge>[] graph,int vertex){
// //           for (int i = 0; i < graph[vertex].size(); i++) {
// //             Edge eg=graph[vertex].get(i);
// //             System.out.print(eg.dest+"   ");
// //           }
// //     }

// //     public static void BreathFirstTraversal(ArrayList<Edge> graph[]){
// //         boolean visited[]=new boolean[graph.length];
// //         Queue<Character> q=new LinkedList<>();
// //         q.add('A');
// //         while (q.size()>0) {
// //             char ch=q.remove();
// //             System.out.print(ch+"     ");
// //             int Chindx=vertices.indexOf(ch);
// //             visited[Chindx]=true;
// //             for (int i = 0; i < graph[Chindx].size(); i++) {
// //                 Edge eg=graph[Chindx].get(i);
// //                 int destindx=vertices.indexOf(eg.dest);
// //                 if (!visited[destindx]) {
// //                     q.add(eg.dest);
// //                 }
// //             }
// //         }
// //     }

// //     public static void PrintDegree(ArrayList<Edge> graph[],char vertex){
// //            int indx=vertices.indexOf(vertex);
// //            int i;
// //            for (i = 0; i < graph[indx].size(); i++) {
               
// //            }
// //            System.out.println("the degree of  vertex "+vertex+"  is "+i);
// //     }
// //     public static void main(String[] args) {
// //         Scanner sc=new Scanner(System.in);

// //         vertices.add('A');
// //         vertices.add('B');
// //         vertices.add('C');
// //         vertices.add('D');
// //         vertices.add('E');
// //         vertices.add('F');
// //         vertices.add('G');
// //         System.out.println(vertices.indexOf('A'));
// //         ArrayList<Edge> graph[]=new ArrayList[7];

// //         CreateGraph(graph);
// //         System.out.println("enter the vertex whose Adjacent Vertices you want to find :");
// //         String vertex=sc.next();
// //         System.out.println("Adjacent vertices of "+vertex+" are :\n");
// //         findAdjacent(graph, vertices.indexOf(vertex.charAt(0)));
// //         System.out.println("breadth traversal is ");
// //         BreathFirstTraversal(graph);
// //         PrintDegree(graph,'A');
        






        
// //         // ArrayList<Edge> 
      


// //         // public static void cycle(ArrayList<Edge> graph[],boolean visited[],int parent,int curr){
// //         //     visited[curr]=true;
// //         //     for (int i = 0; i < graph[curr].size(); i++) {
// //         //         Edge eg=graph[curr].get(i);
// //         //         if (visited[eg.dest]) {
// //         //             if (parent==eg.dest) {
// //         //                 System.out.println("cycle is present ");
// //         //                 return;
// //         //             }
                    
// //         //         }
// //         //         cycle(graph, visited, curr, eg.dest);
// //         //     }
    
// //         // }
// //     }
// // }
