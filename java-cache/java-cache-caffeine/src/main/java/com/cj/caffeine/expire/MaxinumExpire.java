package com.cj.caffeine.expire;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.LoadingCache;


public class MaxinumExpire {
    public static void main(String[] args) {
        // 1. 基于大小的存储方式
        LoadingCache<String, Object> cache = Caffeine.newBuilder()
                .maximumSize(1)
                .build(k -> new Object());
        // 当我们添加一个值时，大小明显增加
        cache.get("A");
        System.out.println(cache.estimatedSize() + ":" + cache.get("A"));
        // 当我们添加第二个值时，淘汰第一个
        cache.get("B");
        System.out.println(cache.estimatedSize() + ":" + cache.get("B"));
    }
}
