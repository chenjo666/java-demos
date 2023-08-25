package com.cj.data_structure.Queue.priorityQueue.comparator;
import java.util.PriorityQueue;

public class BigHeap {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 2, 8, 9, 4};
        // 按照一维数组排序
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
//9 8 5 4 2 1