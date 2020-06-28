/*Question
 1. You are given a graph and a src vertex. The vertices represent computers and the edges represent length of lan wire required to connect them.
2. You are required to find the minimum length of wire required to connect all PCs over a network. Print the output in terms of which all PCs need to be connected, and the length of wire between them.

Note -> for output, check the sample output and question video

                               
Input Format
Input has been managed for you
Output Format
Check the sample output
Constraints
None
Sample Input
7
8
0 1 10
1 2 10
2 3 10
0 3 40
3 4 2
4 5 3
5 6 3
4 6 8
Sample Output
[1-0@10]
[2-1@10]
[3-2@10]
[4-3@2]
[5-4@3]
[6-5@3]*/

// **************** this is minimum spanning tree algorithm also called PRIM"S ALGORITHM ******************************

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
        MinimumWires(graph);
    }
    public static class Mpair implements Comparable < Mpair > {
        int vtx;
        int pvtx;
        int wt;
        Mpair(int v, int p, int w) {
            this.vtx = v;
            this.pvtx = p;
            this.wt = w;
        }
        public int compareTo(Mpair o) {
            return this.wt - o.wt;
        }
    }
    public static void MinimumWires(ArrayList < Edge > graph[]) {
        PriorityQueue < Mpair > pq = new PriorityQueue < > ();
        boolean[] visited = new boolean[graph.length];

        int src = 0;
        pq.add(new Mpair(src, -1, 0));

        while (pq.size() != 0) {
            Mpair tmp = pq.remove();

            if (!visited[tmp.vtx]) {
                visited[tmp.vtx] = true;

                if (tmp.pvtx != -1) {
                    System.out.println("[" + tmp.vtx + "-" + tmp.pvtx + "@" + tmp.wt + "]");
                }
                for (Edge e: graph[tmp.vtx]) {
                    if (!visited[e.nbr]) {
                        pq.add(new Mpair(e.nbr, tmp.vtx, e.wt));
                    }
                }
            }
        }
    }
}