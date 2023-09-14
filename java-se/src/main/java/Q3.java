import java.util.Scanner;

public class Q3  {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt(), s = in.nextInt(), t = in.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        System.out.println(getAns(n, m, s, t, a));
    }

    public static long getAns(int n, int m, int s, int t, int[][] a) {
        Uf uf = new Uf(n);
        for (int i = 0; i < m; i++) {
            uf.union(a[i][0], a[i][1]);
        }

        int p1 = uf.find(s);
        int p2 = uf.find(t);
        if (p1 == p2) {
            return (long)n * (n - 1) / 2;
        } else {
            int c1 = uf.getCnt(p1);
            int c2 = uf.getCnt(p2);
            return (long)c1 * c2;
        }
    }

    static class Uf {
        private int[] parent;

        public Uf(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py) {
                parent[px] = py;
            }
        }

        public int getCnt(int p) {
            int cnt = 0;
            for (int i = 1; i <= parent.length - 1; i++) {
                if (find(i) == p) {
                    cnt++;
                }
            }
            return cnt;
        }
    }
}
