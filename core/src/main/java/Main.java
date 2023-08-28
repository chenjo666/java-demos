import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] chs = new char[n];
        for (int i = 0; i < n; i++) {
            chs[i] = in.next().charAt(0);
        }

        ArrayList[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt(), v = in.nextInt();
            graph[u].add(v);
        }

        dfs(graph, chs, 0,"");

        System.out.println(ans);
    }

    public static void dfs(List<Integer>[] graph, char[] chs, int cur, String str) {
        if (chs[cur] == 'm' && str.equals("yh")) {
            ans += 2;
        }
        if (chs[cur] == 'y' && str.equals("mh")) {
            ans += 2;
        }
        for (Integer i : graph[cur]) {
            if (chs[cur] == 'm') {
                if (str.equals("yh")) {
                    dfs(graph, chs, i, str + 'm');
                } else {
                    dfs(graph, chs, i, "m");
                }
            } else if (chs[cur] == 'h') {
                if (str.equals("m") || str.equals("y")) {
                    dfs(graph, chs, i, str + 'h');
                } else {
                    dfs(graph, chs, i, "");
                }
            } else if (chs[cur] == 'y') {
                if (str.equals("mh")) {
                    dfs(graph, chs, i, str + 'y');
                } else {
                    dfs(graph, chs, i, "y");
                }
            }
        }
    }
}
