package com.cj.tests;

import com.cj.argorithm.sort.BubbleSort;
import com.cj.argorithm.util.DataUtil;
import com.cj.argorithm.util.PrintUtil;
import com.cj.argorithm.sort.QuickSort;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class TestSort {
    static int ARRAY_COUNT = 30;
    static int MIN_NUM = -100, MAX_NUM = 100;
    int[] arr = new int[ARRAY_COUNT];

    void generator() {
        Random random = new Random();
        for (int i = 0; i < ARRAY_COUNT; i++) {
            arr[i] = random.nextInt(MAX_NUM - MIN_NUM) + MIN_NUM;
        }
        PrintUtil.printArray(arr);
    }

    boolean checkExpect() {
        PrintUtil.printArray(arr);
        return DataUtil.isOrderly(arr);
    }

    @Test
    void testQuickSort() {
        generator();
        new QuickSort().sort(arr);
        System.out.println(checkExpect());
    }

    @Test
    void testBubbleSort() {
        generator();
        new BubbleSort().sort(arr);
        System.out.println(checkExpect());
    }
}
