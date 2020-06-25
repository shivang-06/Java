import java.util.*;

public class Main {
    
    private static class Edge{
        int src ; // source
        int dest; // destination
        int wt; //weight
        
        Edge(int src , int dest , int w){
            this.src = src;
            this.dest = dest;
            this.wt = w;
        }
    }
    
    public static void main(String[] args) {
        int vtx = 7; // no. of vertices
        ArrayList<Edge> graph[] = new ArrayList[vtx];
        
        for(int i = 0; i< graph.length ; i++){
            graph[i] = new ArrayList<>();
        }
        
        //For 0 vtx
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,3,40));
        
        //for 1 vtx 
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,10));
        
        //for 2 vtx
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,10));
        
        //For 3 Vtx
        graph[3].add(new Edge(3,0,40));
        graph[3].add(new Edge(3,2,10));
        graph[3].add(new Edge(3,4,5));
        
        //For 4 vtx
        graph[4].add(new Edge(4,3,5));
        graph[4].add(new Edge(4,5,3));
        graph[4].add(new Edge(4,6,8));
        
        //For 5 vtx
        graph[5].add(new Edge(5,4,3));
        graph[5].add(new Edge(5,6,4));
        
        //For 6 vtx 
        graph[6].add(new Edge(6,4,8));
        graph[6].add(new Edge(6,5,4));
        
        for(int v = 0; v <graph.length;v++){
            System.out.print("Vertex "+v + " ---> ");
            for(Edge e : graph[v]){
                System.out.print(e.dest + " @ " + e.wt+ " , ");
            }
            System.out.println(".");
        }
        
    }
}

//OUTPUT :-
    // Vertex 0 ---> 1 @ 10 , 3 @ 40 , .
    // Vertex 1 ---> 0 @ 10 , 2 @ 10 , .
    // Vertex 2 ---> 1 @ 10 , 3 @ 10 , .
    // Vertex 3 ---> 0 @ 40 , 2 @ 10 , 4 @ 5 , .
    // Vertex 4 ---> 3 @ 5 , 5 @ 3 , 6 @ 8 , .
    // Vertex 5 ---> 4 @ 3 , 6 @ 4 , .
    // Vertex 6 ---> 4 @ 8 , 5 @ 4 , .
