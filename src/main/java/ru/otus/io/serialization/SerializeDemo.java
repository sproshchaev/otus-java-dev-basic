package ru.otus.io.serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

/**
 * Пример 1. Сериализация объекта: ObjectOutputStream.writeObject.
 * Превращаем объект в набор байт и сохраняем его в файл.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        User user = new User("Иван", 30);

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
            System.out.println("Объект сериализован в user.ser: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
