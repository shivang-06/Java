/*Question
1. You are given a 2d array where 0's represent land and 1's represent water. Assume every cell is linked to it's north, east, west and south cell.
2. You are required to find and count the number of islands.
Input Format
Input has been managed for you
Output Format
Number of islands
Constraints
None
Sample Input
8
8
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
1 1 1 1 1 1 1 0
1 1 0 0 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 0 1 1 0
1 1 1 1 1 1 1 0
1 1 1 1 1 1 1 0
Sample Output
3
*/
import java.io.*;
import java.util.*;

public class Main {
    public static class Edge {
        int src;
        int nbr;
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        ArrayList < Edge > [] graph = new ArrayList[n];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList < > ();
        }
        // write your code here
        for (int i = 0; i < k; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        System.out.println(friendPairs(graph));
    }
    public static int friendPairs(ArrayList < Edge > [] graph) {
        ArrayList < ArrayList < Integer >> clubs = getAllConnected(graph);

        ArrayList < Integer > clubFreq = new ArrayList < > ();
        for (ArrayList < Integer > club: clubs) {
            clubFreq.add(club.size());
        }

        int nop = 0; //number of pairs
        for (int i = 0; i < clubFreq.size(); i++) {
            for (int j = i + 1; j < clubFreq.size(); j++) {
                nop += clubFreq.get(i) * clubFreq.get(j);
            }
        }
        return nop;
    }
    public static ArrayList < ArrayList < Integer >> getAllConnected(ArrayList < Edge > [] graph) {
        ArrayList < ArrayList < Integer >> comps = new ArrayList < > ();
        boolean[] visited = new boolean[graph.length];

        // write your code here
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                //unvisited vtx
                ArrayList < Integer > comp = new ArrayList < > ();
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
            if (!visited[e.nbr])
                gcc(graph, e.nbr, visited, comp);
        }

    }
}