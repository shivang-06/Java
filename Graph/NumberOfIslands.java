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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][n];

        for (int i = 0; i < arr.length; i++) {
            String parts = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
            }
        }

        // write your code here
        System.out.println(islands(arr));
    }
    public static int islands(int[][] area) {
        //1-> water
        //0->land
        int count = 0;
        boolean visited[][] = new boolean[area.length][area[0].length];
        for (int i = 0; i < area.length; i++) {
            for (int j = 0; j < area[0].length; j++) {
                if (visited[i][j] == false && area[i][j] == 0) {
                    //unvisited and land
                    gcc(area, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void gcc(int[][] area, int i, int j, boolean[][] visited) {
        //north , east , west , south
        //mark all the land

        //north
        if (i - 1 >= 0 && area[i-1][j] == 0 && !visited[i-1][j]) {
            visited[i - 1][j] = true;
            gcc(area, i - 1, j, visited);
        }
        //east
        if (j + 1 < area[0].length && area[i][j+1] == 0 && !visited[i][j+1]) {
            visited[i][j + 1] = true;
            gcc(area, i, j + 1, visited);
        }
        //west
        if (j - 1 >= 0 && area[i][j-1] == 0 && !visited[i][j-1]) {
            visited[i][j - 1] = true;
            gcc(area, i, j - 1, visited);
        }
        //south
        if (i + 1 < area.length && area[i+1][j] == 0 && !visited[i+1][j]) {
            visited[i + 1][j] = true;
            gcc(area, i + 1, j, visited);
        }
    }

}