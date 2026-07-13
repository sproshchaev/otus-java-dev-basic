package ru.otus.io.serialization;

import java.io.*;

/**
 * Пример 4. Поле transient не сериализуется.
 * Исключаем отдельное поле из сериализации с помощью ключевого слова transient.
 */
public class TransientDemo {

    static class Account implements Serializable {
        String login = "admin";
        transient String password = "secret123";   // не будет сохранён

        @Override
        public String toString() {
            return "Account{login='" + login + "', password='" + password + "'}";
        }
    }

    public static void main(String[] args) {
        // Сериализация
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("account.ser"))) {
            Account account = new Account();
            System.out.println("До сериализации:      " + account);
            out.writeObject(account);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("account.ser"))) {
            Account restored = (Account) in.readObject();
            System.out.println("После десериализации: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
