package ru.otus.io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * Пример 3. Без Serializable сериализация невозможна.
 * Попытка сериализовать объект класса без Serializable → NotSerializableException.
 */
public class NotSerializableDemo {

    // Класс НЕ реализует Serializable
    static class Point {
        int x = 1;
        int y = 2;
    }

    public static void main(String[] args) {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("point.ser"))) {
            out.writeObject(new Point());     // здесь будет NotSerializableException
            System.out.println("Это сообщение не выведется");
        } catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}
