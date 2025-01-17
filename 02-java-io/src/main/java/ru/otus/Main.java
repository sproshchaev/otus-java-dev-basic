package ru.otus;

import java.io.*;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 16-01-2025
 * 1) Записываем этот экземпляр в файл, используя классы ObjectOutputStream и FileOutputStream и метод .writeObject().
 * 2) Читаем экземпляр книги из файла book.ser, используя ObjectInputStream и .readObject().
 */
public class Main {

    public static void main(String[] args) {

        Book book = new Book(1, "Title", "Author");

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            objectOutputStream.writeObject(book);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Book book2 = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("book.ser"))) {
            book2 = (Book) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println(book2);
    }
}