package com.cj;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();

        Arrays.sort(a);
        int p = 0;
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            ans += a[j] - p;
            p = a[i];
        }

        System.out.println(ans);
    }
}
