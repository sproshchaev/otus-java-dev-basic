package ru.otus.io.serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

/**
 * Пример 2. Десериализация объекта: ObjectInputStream.readObject.
 * Из набора байт восстанавливаем полноценный объект обратно в память.
 * Читает файл user.ser, созданный в Примере 1 — запустите сначала SerializeDemo.
 */
public class DeserializeDemo {
    public static void main(String[] args) {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("user.ser"))) {
            User user = (User) in.readObject();
            System.out.println("Объект восстановлен из user.ser: " + user);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
