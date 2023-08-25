package com.cj.collection;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        new ArrayList<>();
        new LinkedList<>();
        Map<String, Object> map = new HashMap<>();
        map.put(null, "hello");
        System.out.println(map.get(null));
        String a = "string";
        String b = "string";
        map.put(a, 1);
        map.put(b, 2);

        System.out.println(map.get(a));

        Map<ObjKey, Object> objKeyMap = new HashMap<>();
        ObjKey k1 = new ObjKey("hello");
        ObjKey k2 = new ObjKey("hello");
        objKeyMap.put(k1, 1);
        objKeyMap.put(k2, 2);
        System.out.println("k1: " + objKeyMap.get(k1));
        System.out.println("k2: " + objKeyMap.get(k2));
        Set<Object> objects = new HashSet<>();
    }
}
class ObjKey {
    private String name;

    public ObjKey(String name) {
        this.name = name;
    }
}
