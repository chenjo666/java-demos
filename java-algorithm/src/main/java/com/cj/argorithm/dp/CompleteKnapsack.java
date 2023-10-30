package com.cj.argorithm.dp;

import java.util.Scanner;

/**
 * 完全背包问题:
 * 有 $n$ 个物品，第 $i$ 个物品价值为 $v_i$，重量为 $w_i$，现有一个背包重量为 $k$，
 * 每个物品可以放无穷个，求该背包最多能装取的价值总和。
 */
public class CompleteKnapsack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt(), k = in.nextInt();
        int[] v = new int[n], w = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = in.nextInt();
            w[i] = in.nextInt();
        }

        System.out.println(getAns(n, v, w, k));
    }

    public static int getAns(int n, int[] w, int[] v, int k) {
        int[][] f = new int[n + 1][k + 1];
        // 拆分子问题
        for (int i = 0; i < n; i++) {
            // 枚举背包容量
            for (int j = 1; j <= k; j++) {
                // 枚举次数 0 ~ ∞
                for (int c = 0; c * w[i] <= j; c++) {
                    f[i + 1][j] = Math.max(f[i + 1][j], f[i][j - c * w[i]] + c * v[i]);
                }
            }
        }
        return f[n][k];
    }

    public static int getAns2(int n, int[] w, int[] v, int k) {
        int[][] f = new int[n + 1][k + 1];
        // 拆分子问题
        for (int i = 0; i < n; i++) {
            // 枚举背包容量
            for (int j = 1; j <= k; j++) {
                if (j - w[i] < 0) {
                    f[i + 1][j] = f[i][j];
                } else {
                    f[i + 1][j] = Math.max(f[i][j], f[i + 1][j - w[i]] + v[i]);
                }
            }
        }
        return f[n][k];
    }
}
