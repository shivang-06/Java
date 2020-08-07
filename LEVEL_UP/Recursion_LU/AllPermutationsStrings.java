import java.util.*;

public class AllPermutationsStrings {

  public static void main(String[] args) {
    // System.out.println(stringPermutations("abcd",""));

    System.out.println(uniquePermutations("aba", ""));
  }

  public static int stringPermutations(String s, String asf) {
    if (s.length() == 0) {
      System.out.println(asf);
      return 1;
    }
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String remString = s.substring(0, i) + s.substring(i + 1);

      count += stringPermutations(remString, asf + ch);
    }
    return count;
  }

  public static int uniquePermutations(String s, String asf) {
    if (s.length() == 0) {
      System.out.println(asf);
      return 1;
    }
    int count = 0;
    boolean[] vis = new boolean[26];
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      String remString = s.substring(0, i) + s.substring(i + 1);
      if (!vis[s.charAt(i) - 'a']) {
        count += uniquePermutations(remString, asf + ch);
      }
      vis[s.charAt(i) - 'a'] = true;
    }
    return count;
  }
}
