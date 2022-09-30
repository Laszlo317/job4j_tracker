package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("Clean Code", 1000);
        books[1] = new Book("TIJ3", 1000);
        books[2] = new Book("TIJ4", 1000);
        books[3] = new Book("TIJ5", 1000);
        for (Book book : books) {
            System.out.println(book.getName() + " contains " + book.getPages());
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " contains " + book.getPages());
        }
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + " contains " + book.getPages());
            }
        }
    }
}
