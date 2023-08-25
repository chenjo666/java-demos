package com.cj.caffeine.load;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class AsyncLoad {
    public static void main(String[] args) {
        AsyncLoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .buildAsync(k -> getObject(k));

        String key = "A";
        // 1. get
        cache.get(key)
                .thenAccept(obj -> {
                    System.out.println(obj);
                });
        // 2. getAll
        cache.getAll(Arrays.asList("A", "B", "C"))
                .thenAccept(obj -> {
                    System.out.println(obj);
                });
    }
    public static Object getObject(String key) {
        return new Object();
    }
}
