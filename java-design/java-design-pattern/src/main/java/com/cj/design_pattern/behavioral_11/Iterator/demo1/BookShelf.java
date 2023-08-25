package com.cj.design_pattern.behavioral_11.Iterator.demo1;

import java.util.ArrayList;
import java.util.List;

public class BookShelf implements MyAggregate {
    private List<Book> books;

    public BookShelf() {
        this.books = new ArrayList<>();
    }

    @Override
    public MyIterator iterator() {
        return new BookShelfIterator(this);
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public int getSize() {
        return this.books.size();
    }

    public Book getBookAt(int index) {
        return this.books.get(index);
    }
}
