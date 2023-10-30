package com.cj.argorithm.dp;

import java.util.Scanner;

public class Zero_OneKnapsack {
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


    public static int getAns(int n, int[] v, int[] w, int k) {
        int[][] f = new int[n + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                if (j - w[i] < 0) {
                    f[i + 1][j] = f[i][j];
                } else {
                    f[i + 1][j] = Math.max(f[i][j], f[i][j - w[i]] + v[i]);
                }
            }
        }
        return f[n][k];
    }

}
