package com.cj.data_structure.Queue.priorityQueue.comparator;

import java.util.PriorityQueue;

public class twoComparator {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{5, 1}, {4, 6}, {3, 2}, {7, 1}};
        // 二维排序，按第二个元素排序（从大到小 b-a）
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int[] num : nums) {
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            int[] tuple = pq.poll();
            System.out.print(tuple[0] + " " + tuple[1] + ", ");
        }
        // 4 6, 3 2, 7 1, 5 1,
        // 二维排序，按第一个元素排序（从大到小 b-a）
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int[] num : nums) {
            pq2.offer(num);
        }
        while (!pq2.isEmpty()) {
            int[] tuple = pq2.poll();
            System.out.print(tuple[0] + " " + tuple[1] + ", ");
        }
        // 7 1, 5 1, 4 6, 3 2,
    }
}
