package ru.otus.io.serialization;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Пример 7. Сериализация коллекции.
 * Сохраняем и восстанавливаем целую коллекцию объектов одним вызовом.
 */
public class CollectionDemo {

    static class Product implements Serializable {
        String title;
        double price;
        Product(String title, double price) {
            this.title = title;
            this.price = price;
        }
        @Override public String toString() {
            return title + " (" + price + ")";
        }
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Книга", 500.0));
        products.add(new Product("Ручка", 50.0));

        // Сериализуем весь список одним вызовом
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("products.ser"))) {
            out.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализуем список обратно
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("products.ser"))) {
            @SuppressWarnings("unchecked")
            List<Product> restored = (List<Product>) in.readObject();
            System.out.println("Восстановлен список: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
