package com.cj.design_pattern.flyweight.demo1;

import java.util.HashMap;

// 阅览室
class ReadingRoom {
    private HashMap<Integer, Book> bookshelf;
    public ReadingRoom() {
        this.bookshelf = new HashMap<>();
    }

}


