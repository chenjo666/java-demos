package com.cj.collection;

import java.util.ArrayList;
import java.util.List;

public class ListSortDemo {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>(List.of(0, 1, 2)));
        list.add(new ArrayList<>(List.of(1, 2, 2)));
        list.add(new ArrayList<>(List.of(0, 2, 2)));

        list.sort((o1, o2) -> o1.get(1) - o2.get(1));
    }
}
