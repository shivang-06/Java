/*Question
 1. You are given a graph, and a src vertex.
2. You are required to do a breadth first traversal and print which vertex is reached via which path, starting from the src.

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
0 3 10
3 4 10
4 5 10
5 6 10
4 6 10
2
Sample Output
2@2
1@21
3@23
0@210
4@234
5@2345
6@2346*/
import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int src;
        int nbr;

        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }
    public static class Pair {
        int vtx;
        String psf;
        Pair(int v, String p) {
            this.vtx = v;
            this.psf = p;
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
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
        }

        int src = Integer.parseInt(br.readLine());

        // write your code here 
        bfs(graph, src);
    }
    public static void bfs(ArrayList < Edge > [] graph, int src) {
        Queue < Pair > q = new ArrayDeque < > ();
        boolean[] visited = new boolean[graph.length];
        q.add(new Pair(src, "" + src));
            while (q.size() != 0) {
                Pair tmp = q.remove();
                if (!visited[tmp.vtx]) {

                    //mark
                    visited[tmp.vtx] = true;
                    //print
                    System.out.println(tmp.vtx + "@" + tmp.psf);
                    //add
                    for(Edge e : graph[tmp.vtx]){
                        if(!visited[e.nbr]){
                            q.add(new Pair(e.nbr,tmp.psf+e.nbr));
                        }
                    }
                }

            }
        }
    }