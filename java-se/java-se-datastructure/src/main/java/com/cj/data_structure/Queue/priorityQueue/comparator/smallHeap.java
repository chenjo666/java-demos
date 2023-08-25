package com.cj.data_structure.Queue.priorityQueue.comparator;

import java.util.PriorityQueue;

public class smallHeap {
    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 8, 3};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }
    }
}
