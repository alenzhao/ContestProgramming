package contests.completed.codeforces;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B284 {
  
  public void solve() throws IOException {
    int n = nextInt();
    int m = nextInt();
    
    Map<String, String> wordMap = new HashMap<String, String>();
    
    for (int x = 0; x < m; x++) {
      String first = nextToken();
      String second = nextToken();
      if (second.length() < first.length()) {
        wordMap.put(first, second);
      }
    }
    
    StringBuffer output = new StringBuffer();
    
    for (int x = 0; x < n; x++) {
      String word = nextToken();
      if (x != 0) {
        output.append(" ");
      }
      if (wordMap.containsKey(word)) {
        output.append(wordMap.get(word));
      } else {
        output.append(word);
      }
    }
    
    System.out.println(output.toString());
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
    new B284().run();
  }
}
