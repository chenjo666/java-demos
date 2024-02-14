package com.cj.argorithm.graph;

/**
 * @author chenjian
 * @datetime 2024-02-14 17:08
 */
public class Floyd {

    /**
     * 节点个数
     */
    private final int n;
    /**
     * 最短距离
     */
    private final int[][] distance;
    /**
     * 最短路径
     */
    private final int[][] path;

    /**
     * 顶点间，不可达距离值
     */
    private static final int INF_DISTANCE = Integer.MAX_VALUE / 2;
    /**
     * 顶点间，直接相连路径标记
     */
    private static final int CONNECTED_PATH = -1;

    /**
     * <p>初始化最短距离，最短路径</p>
     * 时间复杂度
     * <ul>
     *     <li>距离矩阵 | 路径矩阵 O(n^2)</li>
     *     <li>计算最短距离 | 最短路径 O(n^3)</li>
     * </ul>
     * 空间复杂度
     * <ul>
     *     <li>距离矩阵 | 路径矩阵 O(n^2)</li>
     * </ul>
     *
     * @param graph 图
     * @param n     节点个数（0 ~ n-1）
     */
    public Floyd(int[][] graph, int n) {
        this.distance = new int[n][n];
        this.path = new int[n][n];
        this.n = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                this.distance[i][j] = graph[i][j];
                this.path[i][j] = CONNECTED_PATH;
            }
        }

        for (int k = 0; k < n; k++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    if (this.distance[u][v] > this.distance[u][k] + this.distance[k][v]) {
                        this.distance[u][v] = this.distance[u][k] + this.distance[k][v];
                        this.path[u][v] = k;
                    }
                }
            }
        }

        printDistance();
        printPath();
    }

    /**
     * 输出两个顶点的距离
     * 时间复杂度 O(1)
     *
     * @param u 顶点u
     * @param v 顶点v
     * @return 顶点u和顶点v之间的距离 int
     */
    public int getDistance(int u, int v) {
        return this.distance[u][v];
    }

    /**
     * 输出两个顶点的路径
     * 时间复杂度 O(n)
     *
     * @param u 顶点u
     * @param v 顶点v
     * @return 顶点u和顶点v之间的路径 String
     */
    public String getPath(int u, int v) {
        if (this.path[u][v] == CONNECTED_PATH) {
            return u + "->" + v;
        }
        int k = this.path[u][v];
        return getPath(u, k) + "," + getPath(k, v);
    }

    private void printDistance() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.distance[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void printPath() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(this.path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {0, INF_DISTANCE, INF_DISTANCE, INF_DISTANCE, 2},
                {1, 0, INF_DISTANCE, 2, 3},
                {1, 1, 0, INF_DISTANCE, INF_DISTANCE},
                {2, 2, 3, 0, INF_DISTANCE},
                {INF_DISTANCE, INF_DISTANCE, INF_DISTANCE, INF_DISTANCE, 0}
        };
        Floyd floyd = new Floyd(graph, 5);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println(i + "->" + j + "::" + floyd.getPath(i, j) + "::" + floyd.getDistance(i, j));
            }
        }
    }
}
