package com.cj.argorithm.util;

public class DataUtil {


    public static boolean isOrderly(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
