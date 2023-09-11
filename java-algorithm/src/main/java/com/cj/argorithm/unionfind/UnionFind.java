package com.cj.argorithm.unionfind;

public class UnionFind {
    private int[] parent;
    private int[] rank;

    // 初始化
    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * 查找 - 普通版本
     * @function 输入一个节点，返回节点所在的集合
     * @param x
     * @return int: x 所在的集合
     * @time: O(n)
     * @space: O(n)
     */
    public int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return parent[x];
    }
    /**
     * 查找 - 压缩版本
     * @function 输入一个节点，返回节点所在的集合
     * @param x
     * @return int: x 所在的集合
     * @time: O(1)
     * @space: O(1)
     */
    public int findByPathCompression(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    /**
     * 合并：将 x 所在集合以及 y 所在集合进行合并
     * 默认将 x 所在的集合合并到 y 中
     * @param x
     * @param y
     */
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) {
            parent[px] = py;
        }
    }

    /**
     * 合并 - 按秩合并
     * @function 合并 x 和 y 所在集合，根据树的高度进行合并；如果 x 的高度更小，则合并进 y；反之亦然；
     * 如果两个节点的高度一致，默认将 x 合并进 y，并将 y 的高度加一
     * @param x
     * @param y
     */
    public void unionByRank(int x, int y) {
        int px = find(x);
        int py = find(y);
        // 按秩合并
        if (rank[px] > rank[py]) {
            parent[py] = px;
        } else if (rank[px] < rank[py]) {
            parent[px] = py;
        } else {
            parent[px] = py;
            rank[py]++;
        }
    }
}
