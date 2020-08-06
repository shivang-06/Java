public class mazePathWithJumps {

  public static void main(String[] args) {
    // System.out.println(solve(0, 0, 2, 2, ""));
    floodFill();
  }

  public static int solve(int sr, int sc, int dr, int dc, String psf) {
    if (sr > dr || sc > dc) {
      return 0;
    }
    if (sr == dr && sc == dc) {
      System.out.println(psf);
      return 1;
    }
    int count = 0;
    //horizontal
    for (int jump = 1; sc + jump <= dc; jump++) {
      count += solve(sr, sc + jump, dr, dc, psf + "H" + jump);
    }
    //vertical
    for (int jump = 1; sr + jump <= dr; jump++) {
      count += solve(sr + jump, sc, dr, dc, psf + "V" + jump);
    }

    for (int jump = 1; sr + jump <= dr && sc + jump <= dc; jump++) {
      count += solve(sr + jump, sc + jump, dr, dc, psf + "D" + jump);
    }
    return count;
  }

  public static int floodFill_(int sr,int sc,int dr,int dc,boolean[][] visited,int[][] dir,String[] dirS,String ans){
    if (sr == dr && sc == dc) {
      System.out.println(ans);
      return 1;
    }

    visited[sr][sc] = true;
    int count = 0;
    for (int d = 0; d < 4; d++) {
      int r = sr + dir[d][0];
      int c = sc + dir[d][1];
      if (r >= 0 && c >= 0 && r <= dr && c <= dc && visited[r][c] == false) {
        count +=floodFill_(r, c, dr, dc, visited, dir, dirS, ans + dirS[d] + " ");
      } 
    }
    visited[sr][sc] = false;
    return count;
  }

  public static void floodFill() {
    int sr = 0, sc = 0, dr = 3, dc = 3;

    int[][] dirFour = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    String[] dirS = { "D", "U", "R", "L" };
    boolean[][] visited = new boolean[dr + 1][dc + 1];
    System.out.println(floodFill_(sr, sc, dr, dc, visited, dirFour, dirS, ""));
  }
}
