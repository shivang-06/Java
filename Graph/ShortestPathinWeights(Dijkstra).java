/*Question
1. You are given a graph and a src vertex. The vertices represent cities and the edges represent distance in kms.
2. You are required to find the shortest path to each city (in terms of kms) from the src city alongwith the total distance on path from src to destinations.

Note -> for output, check the sample output and question video
Input Format
Input has been managed for you
Output Format
Check the sample output
Constraints
None
Sample Input
7
9
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
2 5 5
0
Sample Output
0 via 0 @ 0
1 via 01 @ 10
2 via 012 @ 20
5 via 0125 @ 25
4 via 01254 @ 28
6 via 01256 @ 28
3 via 012543 @ 30*/

// ********************this is known as DIJKSTRA'S ALGORITHM*************************************
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      int src = Integer.parseInt(br.readLine());
      // write your code here
      shortesPathInWeight(graph,src);
      
   }
   public static class Pair implements Comparable<Pair>{
        int vtx;
        String psf;
        int wsf;
        Pair(int v,String s,int w){
            this.vtx = v;
            this.psf = s;
            this.wsf = w;
        }
        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    
    public static void shortesPathInWeight(ArrayList<Edge> graph[], int src){
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,""+src,0) );
        while(pq.size()!=0){
            //remove
            Pair tmp = pq.remove();
            //mark+print
            if(!visited[tmp.vtx]){
                visited[tmp.vtx] = true;
                System.out.println(tmp.vtx + " via "+tmp.psf+" @ "+tmp.wsf);
                //add
                for(Edge e : graph[tmp.vtx]){
                    if(!visited[e.nbr]){
                        pq.add(new Pair(e.nbr, tmp.psf+e.nbr, tmp.wsf+e.wt));
                    }
                }
            }
        }
}
}