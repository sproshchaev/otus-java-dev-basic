package ru.otus.io.serialization;

import java.io.*;

/**
 * Пример 6. Граф объектов: сохраняются и вложенные объекты.
 * При сериализации объекта автоматически сохраняются и объекты, на которые он ссылается.
 */
public class ObjectGraphDemo {

    static class Address implements Serializable {
        String city;
        Address(String city) { this.city = city; }
        @Override public String toString() { return "Address{city='" + city + "'}"; }
    }

    static class Person implements Serializable {
        String name;
        Address address;      // ссылка на другой объект
        Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }
        @Override public String toString() {
            return "Person{name='" + name + "', address=" + address + "}";
        }
    }

    public static void main(String[] args) {
        Person person = new Person("Мария", new Address("Москва"));

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream("person.ser"))) {
            out.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream("person.ser"))) {
            Person restored = (Person) in.readObject();
            System.out.println("Восстановлен объект вместе со ссылкой: " + restored);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
