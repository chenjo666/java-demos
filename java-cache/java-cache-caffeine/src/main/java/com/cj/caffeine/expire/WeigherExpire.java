package com.cj.caffeine.expire;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;

public class WeigherExpire {
    public static void main(String[] args) {
        LoadingCache<String, Object> cache = Caffeine.newBuilder()// 每一个<k, v>权重都为 5
                .build(k -> new Object());
        cache.get("A");         // 权重加 5
        cache.get("B");         // 权重加 5

        cache.get("C");         // 权重已满
        cache.cleanUp();
        System.out.println(cache.estimatedSize());
    }
}
