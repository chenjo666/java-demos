package com.cj;

import java.util.Arrays;

public class LambdaDemo {

    public static void main(String[] args) {



        int[][] a = new int[10][2];

        for (int i = 0; i< 10; i++) {
            a[i][1] = i % 2;
        }

        Arrays.sort(a, (o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < 10; i++) {
            System.out.println(a[i][1]);
        }
    }


}