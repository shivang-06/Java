import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList < String > list = getMazePaths(0, 0, n - 1, m - 1);
        System.out.println(list);
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList < String > getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList < String > finAnswer = new ArrayList < > ();
        if (sc > dc || sr > dr) {// when increment column it may go out of matrix!
            ArrayList < String > invalid = new ArrayList < > ();
            return invalid;
        }
        if (sr == dr && sc == dc) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        for (int step = 1; step <= dc; step++) {
            ArrayList < String > answerCol = getMazePaths(sr, sc + step, dr, dc);
            for (String val: answerCol) {
                finAnswer.add("h" + step + val);
            }
        }
        for (int step = 1; step <= dr; step++) {
            ArrayList < String > answerRow = getMazePaths(sr + step, sc, dr, dc);
            for (String val: answerRow) {
                finAnswer.add("v" + step + val);
            }
        }
        for (int step = 1; step <= dc && step <= dr; step++) {
            ArrayList < String > answerDia = getMazePaths(sr + step, sc + step, dr, dc);
            for (String val: answerDia) {
                finAnswer.add("d" + step + val);
            }
        }

        return finAnswer;
    }

}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList < String > list = getStairPaths(n);
        System.out.println(list);
    }

    public static ArrayList < String > getStairPaths(int n) {
        ArrayList < String > finAnswer = new ArrayList < > ();
        //invalid point
        if (n < 0) {
            ArrayList < String > invalid = new ArrayList < > ();
            return invalid;
        }
        //base case || end result achieved
        if (n == 0) {
            ArrayList < String > base = new ArrayList < > ();
            base.add("");
            return base;
        }

        for (int i = 1; i <= 3; i++) {
            ArrayList < String > answer = getStairPaths(n - i);
            
            for (String val: answer) {
                finAnswer.add(i + val);
            }
        }

        return finAnswer;
    }

}