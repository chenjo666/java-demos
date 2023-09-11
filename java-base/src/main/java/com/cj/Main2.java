package com.cj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,2,3,2};
        Arrays.sort(a);
        List<Integer> list = new ArrayList<>();

        int maxCnt = 0, maxIdx = -1;
        for (int left = 0, right = 0; left < a.length;) {

            while (right < a.length && a[right] == a[left]) {
                right++;
            }
            if (right - left > maxCnt) {
                maxCnt = right - left;
                maxIdx = a[left];
            }
            list.add(a[left]);
            left = right;
        }
        for (Integer idx : list) System.out.println(idx);
        System.out.println(maxIdx);
    }
}
