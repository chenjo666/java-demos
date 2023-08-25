package com.cj.data_structure.Queue.priorityQueue.comparator;

import java.util.PriorityQueue;

public class filedComparator {
    public static void main(String[] args) {
        Word word1 = new Word("hello", 2);
        Word word2 = new Word("word", 3);
        Word word3 = new Word("work", 3);
        Word word4 = new Word("wcg", 5);
        Word word5 = new Word("html", 1);
        // 先按次数排序（从大到小排序），再按字典序排序
        PriorityQueue<Word> pq = new PriorityQueue<>((a, b) -> {
            int res1 = b.cnt - a.cnt;
            int res2 = a.val.compareTo(b.val);
            return res1 == 0 ? res2 : res1;
        });
        pq.offer(word1);pq.offer(word2);
        pq.offer(word3);pq.offer(word4);pq.offer(word5);
        while (!pq.isEmpty()) {
            Word word = pq.poll();
            System.out.print(word.val + " " + word.cnt + ", ");
        }
    }
}
class Word {
    String val;
    int cnt;
    public Word(String val, int cnt) {
        this.val = val;
        this.cnt = cnt;
    }
}
