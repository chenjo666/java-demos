package com.cj.argorithm.graph;

/**
 * 对于邻接矩阵表示的有向图 G = (V, E)，设计一个 O(V) 算法，计算 G 中是否存在一个入度为 |V| - 1 且出度为 0 的节点。
 *
 * @author chenjian
 * @datetime 2024-02-04 20:34
 */
public class FindUniversalSink {
    public static void main(String[] args) {
        int n;
        int[][] graph = new int[][]{};
        System.out.println();
    }

    /**
     * 查询是否存在通用汇点
     *
     * @param n     节点个数 (0 ~ n-1)
     * @param graph 邻接矩阵表示的图
     * @return 是否存在通用汇点
     */
    public static boolean isExistUniversalSink(int n, int[][] graph) {
        for (int u = 0; u < n; u++) {
            int v = 0;
            for (; v < n; v++) {
                if (graph[u][v] == 1) {
                    break;
                }
                if (u == v && graph[u][v] == 1) {
                    break;
                }
                if (graph[v][u] == 0) {
                    break;
                }
            }
            if (v == n) {
                return true;
            }
        }
        return false;
    }
}
