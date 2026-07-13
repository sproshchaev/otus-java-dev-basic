package ru.otus.io.serialization;

import java.io.*;

/**
 * Пример 8. Версии класса: serialVersionUID.
 * Поле serialVersionUID помечает версию класса и контролирует совместимость версий.
 */
public class SerialVersionUidDemo {

    static class Book implements Serializable {
        private static final long serialVersionUID = 1L;
        String title = "Java";
        int pages = 300;

        @Override public String toString() {
            return "Book{title='" + title + "', pages=" + pages + "}";
        }
    }

    public static void main(String[] args) {
        // Сериализация
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            out.writeObject(new Book());
            System.out.println("Сериализовано с serialVersionUID = 1");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация — serialVersionUID совпадает, всё читается
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("book.ser"))) {
            Book restored = (Book) in.readObject();
            System.out.println("Десериализовано: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
