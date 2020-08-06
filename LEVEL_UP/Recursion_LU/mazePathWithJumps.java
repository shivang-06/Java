public class mazePathWithJumps {

  public static void main(String[] args) {
    System.out.println(solve(0, 0, 2, 2, ""));
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
}
