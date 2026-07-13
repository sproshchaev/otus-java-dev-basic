package ru.otus.io.serialization;

import java.io.Serializable;

/**
 * Общий класс-модель для Примеров 1–2.
 * Реализует маркерный интерфейс Serializable — только это делает объекты пригодными
 * для сериализации. serialVersionUID подробно разбирается в Примере 8.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }
}
