package com.cj.design_pattern.Iterator.demo1;

public class BookShelfIterator implements MyIterator {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return this.index < this.bookShelf.getSize();
    }

    @Override
    public Object next() {
        return this.bookShelf.getBookAt(this.index++);
    }
}
