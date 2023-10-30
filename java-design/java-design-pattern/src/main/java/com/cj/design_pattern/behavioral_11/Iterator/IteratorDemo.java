package com.cj.design_pattern.behavioral_11.Iterator;

import java.util.ArrayList;
import java.util.List;

class Book {
    private String name;

    public Book(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                '}';
    }
}
class BookShelf implements MyAggregate {
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

class BookShelfIterator implements MyIterator {
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
interface MyAggregate {
    MyIterator iterator();
}
interface MyIterator {
    boolean hasNext();
    Object next();
}

public class IteratorDemo {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf();
        bookShelf.addBook(new Book("Java 设计模式之禅"));
        bookShelf.addBook(new Book("重学 Java 设计模式"));
        bookShelf.addBook(new Book("图解设计模式"));
        bookShelf.addBook(new Book("设计模式之美"));
        MyIterator it = bookShelf.iterator();
        while (it.hasNext()) {
            Book book = (Book)it.next();
            System.out.println(book);
        }
    }
}
