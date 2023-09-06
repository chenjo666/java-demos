package com.cj.caffeine.load;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

public class HandLoad {
    public static void main(String[] args) {
        Cache<String, Object> cache = Caffeine.newBuilder().build();
        cache.put("key", "ok");
        System.out.println(cache.getIfPresent("key"));
    }
}
