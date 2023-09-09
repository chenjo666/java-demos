package com.cj.string;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        String[] s = new String[m];
        for (int i = 0; i < n; i++) {
            s[i] = in.next();
        }
        System.out.println(getAns(n, m, s));
    }
    public static long getAns(int n, int m, String[] s) {
        // 枚举四个直角所在的位置 0 上，1 右，2 下，3 左
        int[][][] y_o = new int[n][m][4];
        int[][][] y_u = new int[n][m][4];
        int[][][] o_y = new int[n][m][4];
        int[][][] o_u = new int[n][m][4];
        int[][][] u_y = new int[n][m][4];
        int[][][] u_o = new int[n][m][4];

        int[] ty = new int[m], to = new int[m], tu = new int[m];
        int[] ly = new int[n], lo = new int[n], lu = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = s[i].charAt(j);
                if (ch == 'y') {
                    y_o[i][j][0] = to[j]; y_o[i][j][3] = lo[i];
                    y_u[i][j][0] = tu[j]; y_u[i][j][3] = lu[i];
                    ty[j]++; ly[i]++;
                } else if (ch == 'o') {
                    o_y[i][j][0] = ty[j]; o_y[i][j][3] = ly[i];
                    o_u[i][j][0] = tu[j]; o_u[i][j][3] = lu[i];
                    to[j]++; lo[i]++;
                } else if (ch == 'u') {
                    u_y[i][j][0] = ty[j]; u_y[i][j][3] = ly[i];
                    u_o[i][j][0] = to[j]; u_o[i][j][3] = lo[i];
                    tu[j]++; lu[i]++;
                }
            }
        }

        int[] by = new int[m], bo = new int[m], bu = new int[m];
        int[] ry = new int[n], ro = new int[n], ru = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                char ch = s[i].charAt(j);
                if (ch == 'y') {
                    y_o[i][j][2] = bo[j]; y_o[i][j][1] = ro[i];
                    y_u[i][j][2] = bu[j]; y_u[i][j][1] = ru[i];
                    by[j]++; ry[i]++;
                } else if (ch == 'o') {
                    o_y[i][j][2] = by[j]; o_y[i][j][1] = ry[i];
                    o_u[i][j][2] = bu[j]; o_u[i][j][1] = ru[i];
                    bo[j]++; ro[i]++;
                } else if (ch == 'u') {
                    u_y[i][j][2] = by[j]; u_y[i][j][1] = ry[i];
                    u_o[i][j][2] = bo[j]; u_o[i][j][1] = ro[i];
                    bu[j]++; ru[i]++;
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = s[i].charAt(j);
                if (ch == 'y') {
                    ans += (long)y_o[i][j][1] * y_u[i][j][2];
                    ans += (long)y_u[i][j][1] * y_o[i][j][2];
                    ans += (long)y_o[i][j][3] * y_u[i][j][2];
                    ans += (long)y_u[i][j][3] * y_o[i][j][2];
                    ans += (long)y_o[i][j][1] * y_u[i][j][0];
                    ans += (long)y_u[i][j][1] * y_o[i][j][0];
                    ans += (long)y_o[i][j][3] * y_u[i][j][0];
                    ans += (long)y_u[i][j][3] * y_o[i][j][0];
                } else if (ch == 'o') {
                    ans += (long)o_y[i][j][1] * o_u[i][j][2];
                    ans += (long)o_u[i][j][1] * o_y[i][j][2];
                    ans += (long)o_y[i][j][3] * o_u[i][j][2];
                    ans += (long)o_u[i][j][3] * o_y[i][j][2];
                    ans += (long)o_y[i][j][1] * o_u[i][j][0];
                    ans += (long)o_u[i][j][1] * o_y[i][j][0];
                    ans += (long)o_y[i][j][3] * o_u[i][j][0];
                    ans += (long)o_u[i][j][3] * o_y[i][j][0];
                } else if (ch == 'u') {
                    ans += (long)u_y[i][j][1] * u_o[i][j][2];
                    ans += (long)u_o[i][j][1] * u_y[i][j][2];
                    ans += (long)u_y[i][j][3] * u_o[i][j][2];
                    ans += (long)u_o[i][j][3] * u_y[i][j][2];
                    ans += (long)u_y[i][j][1] * u_o[i][j][0];
                    ans += (long)u_o[i][j][1] * u_y[i][j][0];
                    ans += (long)u_y[i][j][3] * u_o[i][j][0];
                    ans += (long)u_o[i][j][3] * u_y[i][j][0];
                }
            }
        }

        return ans;
    }
}
