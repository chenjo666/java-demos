package com.cj.data_structure.demo;

import java.util.LinkedHashSet;
import java.util.LinkedList;

public class LRUCache<K, V> {
    private final int capacity;
    private final LinkedHashSet<K> set;
    private final LinkedList<V> list;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.set = new LinkedHashSet<>();
        this.list = new LinkedList<>();
    }

    public void put(K key, V value) {
        if (set.contains(key)) {
            // 如果 key 已存在，将其移动到链表末尾，并更新对应的 value
            list.remove(value);
        } else {
            // 如果 key 不存在，如果容量已满则删除链表头部元素
            if (set.size() == capacity) {
                K oldestKey = set.iterator().next();
                set.remove(oldestKey);
                list.remove();
            }
            set.add(key);
        }
        list.add(value);
    }

    public V get(K key) {
        if (!set.contains(key)) {
            return null;
        }
        V value = null;
        for (V v : list) {
            if (v.hashCode() == key.hashCode()) {
                value = v;
                break;
            }
        }
        if (value != null) {
            list.remove(value);
            list.add(value);
        }
        return value;
    }
}
