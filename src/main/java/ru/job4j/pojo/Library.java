package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book();
        Book tij4 = new Book();
        Book tij5 = new Book();
        Book tij3 = new Book();
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = tij3;
        books[2] = tij4;
        books[3] = tij5;
        for (Book book : books) {
            System.out.println(book.getName() + " contains " + book.getPages());
        }
        Book temp = new Book();
        temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book book : books) {
            System.out.println(book.getName() + " contains " + book.getPages());
        }
        for (Book book : books) {
            if (book.equals(cleanCode)) {
                System.out.println(book.getName() + " contains " + book.getPages());
            }
        }
    }
}
