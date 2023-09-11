package com.cj;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] a = new int[n], b = new int[n - 1];
            for (int j = 0; j < n; j++) a[j] = in.nextInt();
            for (int j = 0; j < n - 1; j++) b[j] = in.nextInt();

            getAns(n, a, b);
            System.out.println();
        }
    }

    public static void getAns(int n, int[] a, int[] b) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int[] buff = new int[n];
        for (int i = 0; i < n; i++) buff[i] = a[i];

        Arrays.sort(buff);
        for (int i = 0; i < n / 2; i++) pqMin.offer(buff[i]);
        for (int i = n / 2; i < n; i++) pqMax.offer(buff[i]);

        print(pqMax, pqMin);
        for (int p : b) {
            int pb = a[p - 1];
            if (pqMax.isEmpty() || pb < pqMax.peek()) {
                pqMin.remove(pb);
                if (pqMin.size() + 1 < pqMax.size()) {
                    pqMin.offer(pqMax.poll());
                }
            } else {
                pqMax.remove(pb);
                if (pqMax.size() + 1 < pqMin.size()) {
                    pqMax.offer(pqMin.poll());
                }
            }
            print(pqMax, pqMin);
        }
    }

    public static void print(PriorityQueue<Integer> pqMax, PriorityQueue<Integer> pqMin) {
        if (pqMax.size() == pqMin.size()) {
            double f = (pqMax.peek() + pqMin.peek()) / 2.0;
            String sf = String.format("%.1f", f);
            if (sf.charAt(sf.length() - 1) == '0') {
                System.out.print((int)f + " ");
            } else {
                System.out.print(f + " ");
            }
        } else if (pqMax.size() > pqMin.size()) {
            System.out.print(pqMax.peek() + " ");
        } else {
            System.out.print(pqMin.peek() + " ");
        }
    }
}
