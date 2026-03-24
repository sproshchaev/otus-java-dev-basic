package com.prosoft;

import java.io.*;

/**
 * Java IO Часть 2
 */
public class Main {

    public static void main(String[] args) {

        Book book = new Book("1L", "bookName");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            oos.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
        Book book2 = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("book.ser"));
            book2 = (Book) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("book2: " + book2);

    }

}