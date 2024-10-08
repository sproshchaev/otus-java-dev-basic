package ru.otus.example.counter;

/**
 * Класс Counter представляет собой простую реализацию счётчика
 */
public class Counter {
    private int value;

    public void inc() {
        value++;
        System.out.println("Counter value after increment: " + value);
    }

    public void dec() {
        value--;
        System.out.println("Counter value after decrement: " + value);
    }

    public int getValue() {
        return value;
    }
}
