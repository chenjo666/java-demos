package com.cj;

import java.util.ArrayList;
import java.util.List;

public class Demo110 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> listsub01 = new ArrayList<>();
        listsub01.add(1);
        listsub01.add(1);
        listsub01.add(1);
        list.add(listsub01);


        list.add(new ArrayList<>());
        list.add(new ArrayList<>());


//        int[][];
    }
}
