package com.cj;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
                            int[] a = new int[]{1,2,3,4,5,2,3,2};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int[] b = new int[map.size()];
        int indx  = 0, max = 0, idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            b[indx++] = entry.getKey();
            if (entry.getValue() > max) {
                max = entry.getValue();
                idx = entry.getKey();
            }
        }
        for (int id : b) System.out.print(id + " ");
        System.out.println(idx);
    }
}
