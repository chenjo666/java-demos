package com.cj.argorithm.sort;

public class QuickSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        return quickSortSimple(arr);
    }
    public int[] quickSortSimple(int[] arr) {
        quickSortSimple(arr, 0, arr.length - 1);
        return arr;
    }
    private void quickSortSimple(int[] arr, int l, int r) {
        if (l < r) {
            int pivot = partition(arr, l, r);
            quickSortSimple(arr, l, pivot - 1);
            quickSortSimple(arr, pivot + 1, r);
        }
    }
    private int partition(int[] arr, int l, int r) {
        int j = l + 1;
        for (int i = j; i <= r; i++) {
            // 小的元素在左边，大的元素在右边
            if (arr[i] < arr[l]) {
                swap(arr, i, j);
                j++;
            }
        }
        // 主轴元素归位
        swap(arr, l, j - 1);
        return j - 1;
    }
}
