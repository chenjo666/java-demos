package com.cj.argorithm.sort;

public interface Sort {
    int[] sort(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
