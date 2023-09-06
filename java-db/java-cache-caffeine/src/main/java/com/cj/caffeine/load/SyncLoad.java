package com.cj.caffeine.load;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class SyncLoad {
    public static void main(String[] args) {
        // 1. 同步方法
        LoadingCache<String, Object> syncLoad = Caffeine.newBuilder().build(k -> getValue(k));
        // 2. 使用 get 将会触发 k -> getValue(k)
        System.out.println(syncLoad.get("key"));
        System.out.println(syncLoad.get("key2"));
    }
    private static Object getValue(String key) {
        return new Object();
    }
}
//java.lang.Object@2e0fa5d3
//java.lang.Object@5010be6