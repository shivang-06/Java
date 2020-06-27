/*Question
1. You are given a graph.
2. You are required to find and print if the graph is cyclic 
Input Format
Input has been managed for you
Output Format
true if the graph is cyclic, false otherwise
Constraints
None
Sample Input
7
6
0 1 10
1 2 10
2 3 10
3 4 10
4 5 10
5 6 10
Sample Output
false*/
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
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
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

        // write your code here
        System.out.println(isCyclic(graph));
    }
    public static boolean isCyclic(ArrayList < Edge > [] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int v = 0; v < graph.length; v++) {
            if (!visited[v]) {
                if (isCyclic(graph, visited, v)) {
                    //graph is cyclic
                    return true;
                }
            }
        }
        //graph is not cyclic
        return false;
    }
    public static boolean isCyclic(ArrayList < Edge > [] graph, boolean[] visited, int src) {
        Queue < Integer > q = new ArrayDeque < > ();
        q.add(src);
        while (q.size() > 0) {
            int vtx = q.remove();

            if (!visited[vtx]) {
                //mark
                visited[vtx] = true;

                //add unvisited nbrs
                for (Edge e: graph[vtx]) {
                    if (!visited[e.nbr]) {
                        q.add(e.nbr);
                    }
                }
            } else {
                //component is cyclic
                return true;
            }
        }
        //component is non-cyclic
        return false;
    }
}