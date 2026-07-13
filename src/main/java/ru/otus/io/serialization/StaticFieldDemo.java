package ru.otus.io.serialization;

import java.io.*;

/**
 * Пример 5. Поле static не является частью объекта.
 * static-поле не сохраняется вместе с объектом — оно принадлежит классу, а не экземпляру.
 */
public class StaticFieldDemo {

    static class Config implements Serializable {
        static String version = "1.0";   // общее для класса, не часть объекта
        String name = "main";

        @Override
        public String toString() {
            return "Config{name='" + name + "', version(static)='" + version + "'}";
        }
    }

    public static void main(String[] args) {
        // Сериализуем объект, когда version = "1.0"
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("config.ser"))) {
            out.writeObject(new Config());
            System.out.println("Сериализовали при version = " + Config.version);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Меняем static-поле уже ПОСЛЕ сериализации
        Config.version = "2.0";

        // Десериализуем
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("config.ser"))) {
            Config restored = (Config) in.readObject();
            System.out.println("Перед чтением изменили static на " + Config.version);
            System.out.println("После десериализации: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
