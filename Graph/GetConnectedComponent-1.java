/*Question
1. You are given a graph.
2. You are required to find and print all connected components of the graph.
Input Format
Input has been managed for you
Output Format
Check the sample output
Constraints
None
Sample Input
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Sample Output
[[0, 1], [2, 3], [4, 5, 6]]*/
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

        System.out.println(getAllConnected(graph));
    }
    
    public static ArrayList < ArrayList < Integer >> getAllConnected(ArrayList < Edge > [] graph) {
        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                //unvisited vtx
                ArrayList<Integer> comp = new ArrayList < > ();
                gcc(graph, i, visited, comp);
                comps.add(comp);
            }
        }

        return comps;
    }
    
    public static void gcc(ArrayList < Edge > [] graph, int vtx, boolean[] visited, ArrayList < Integer > comp) {
        visited[vtx] = true;
        comp.add(vtx);
        for (Edge e: graph[vtx]) {
            if(!visited[e.nbr])
            gcc(graph, e.nbr, visited, comp);
        }

    }
}