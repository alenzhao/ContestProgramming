

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Helper {
  public void solve() throws IOException {
    String[] result = new String[15504];
    int[] val = new int[6];
    val[5] = 15;
    result[0] = toString(val);
    for (int x = 1; x < 15504; x++) {
      for (int y = 5; y >= 0; y--) {
        if (val[y] != 0) {
          val[y - 1]++;
          val[y]--;
          int tot = 0;
          for (int z = y; z < 6; z++) {
            tot += val[z];
            val[z] = 0;
          }
          val[5] = tot;
          break;
        }
      }
      result[x] = toString(val);
    }
  }

  public String toString(int[] val) {
    StringBuilder builder = new StringBuilder();
    for (int x = 0; x < val.length; x++) {
      if (x != 0) {
        builder.append(" ");
      }
      builder.append(val[x]);
    }
    return builder.toString();
  }

  public long choose(int a, int b) {
    long total = 1;
    for (int x = 0; x < b; x++) {
      total *= (a - x);
    }
    for (int x = 1; x <= b; x++) {
      total /= x;
    }
    return total;
  }

  public BufferedReader br;
  public StringTokenizer st;
  public PrintWriter out;

  public String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      st = new StringTokenizer(br.readLine());
    }

    return st.nextToken();
  }

  public String nextLine() throws IOException {
    return br.readLine();
  }

  public int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  public long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  public double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  public void run() throws IOException {
    boolean oj = System.getProperty("ONLINE_JUDGE") != null;
    oj = true;
    br = new BufferedReader(
        new InputStreamReader(oj ? System.in : new FileInputStream("input.txt")));
    out = new PrintWriter(oj ? System.out : new FileOutputStream("output.txt"));
    solve();
    out.close();
  }

  public static void main(String[] args) throws IOException {
    new Helper().run();
  }
}
