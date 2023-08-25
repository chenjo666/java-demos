package com.cj.design_pattern.behavioral_11.Iterator.demo1;

public class Test {
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
