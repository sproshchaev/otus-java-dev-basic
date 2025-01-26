package com.prosoft;

import java.util.ArrayList;

/**
 * Демонстрация производительности методов класса ArrayList
 */
public class ArrayListPerfDemo {

    /**
     * Количество измерений
     */
    public static final int ITERATIONS = 1_000_000;

    /**
     * Базовый размер большой коллекции
     */
    private static final int BASE_SIZE_LARGE = 1_000_000;

    /**
     * Базовый размер малой коллекции
     */
    private static final int BASE_SIZE_SMALL = 10;

    public static long startTime;
    public static long endTime;

    public static void main(String[] args) {

        // Операции с постоянным временем O(1): get(), set(), size()
        get();
        set();
        size();

        // Операции с линейным временем O(n): remove(), contains(), ensureCapacity(), trimToSize()
        remove();
        contains();

        // Особенность метода add():
        //   - если не требуется расширение массива, то O(1)
        add();

        //   - если требуется расширение массива, то O(n)
        addWithExpansion();
    }

    /**
     * Метод get()
     */
    public static void get() {

        System.out.println("Метод get():");

        ArrayList<Integer> smallList = createList(BASE_SIZE_SMALL); // Создаем ArrayList с 10 элементами
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.get(BASE_SIZE_SMALL / 2); // Тестируем производительность небольшого списка - получаем элемент с индексом 5
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        ArrayList<Integer> largeList = createList(BASE_SIZE_LARGE); // Создаем ArrayList с 1 000 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.get(BASE_SIZE_LARGE / 2); // Тестируем производительность большого списка - получаем элемент с индексом 500000
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод set()
     */
    public static void set() {

        System.out.println("Метод set():");

        ArrayList<Integer> smallList = createList(BASE_SIZE_SMALL); // 10 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.set(BASE_SIZE_SMALL / 2, 1000); // Тестируем производительность небольшого списка - устанавливаем значение элемента с индексом 5
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        ArrayList<Integer> largeList = createList(BASE_SIZE_LARGE); // 1 000 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.set(BASE_SIZE_LARGE / 2, 1000); // Тестируем производительность большого списка - устанавливаем значение элемента с индексом 5
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод size()
     */
    public static void size() {

        System.out.println("Метод size():");

        ArrayList<Integer> smallList = createList(BASE_SIZE_SMALL); // Создаем ArrayList с 10 элементами
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.size(); // Тестируем производительность небольшого списка - вызываем метод size()
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        ArrayList<Integer> largeList = createList(BASE_SIZE_LARGE); // Создаем ArrayList с 1 000 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.size(); // Тестируем производительность большого списка - вызываем метод size()
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод remove()
     */
    public static void remove() {

        System.out.println("Метод remove():");

        ArrayList<Integer> smallList = createList(BASE_SIZE_SMALL); // Создаем ArrayList с 10 элементами
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.remove(BASE_SIZE_SMALL / 2); // Тестируем производительность небольшого списка - удаляем элемент из середины с индексом 5
            smallList.add(BASE_SIZE_SMALL / 2, 1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        ArrayList<Integer> largeList = createList(BASE_SIZE_LARGE / 20); // Создаем большой ArrayList с 50 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.remove(BASE_SIZE_LARGE / 40); // Тестируем производительность большого списка - удаляем элемент из середины с индексом 25_000
            largeList.add(BASE_SIZE_LARGE / 40, 1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 20, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод contains()
     */
    public static void contains() {

        System.out.println("Метод contains():");

        // Создаем ArrayList с 10 элементами
        ArrayList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.contains(BASE_SIZE_SMALL / 2);  // Тестируем производительность небольшого списка - проверяем наличие элемента 5
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        ArrayList<Integer> largeList = createList(BASE_SIZE_LARGE / 100); // Создаем ArrayList с 10 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.contains(BASE_SIZE_LARGE / 20);  // Тестируем производительность большого списка - проверяем наличие элемента 5_000
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 100, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод add() без расширения емкости
     */
    public static void add() {

        // Используем более малые коллекции
        int smallSize = 10;
        int largeSize = 100000;
        int iterations = 10000;

        System.out.println("Метод add() без расширения CAPACITY:");
        ArrayList<Integer> smallList;
        long totalTime = 0;
        int countIterations = 0;
        while (countIterations < iterations) {
            smallList = new ArrayList<>(smallSize); // создаем ArrayList с 10 элементами
            for (int i = 0; i < smallSize; i++) {
                startTimer();
                smallList.add(i); // Тестируем производительность небольшого списка - добавляем элемент, не вызывая расширения капасити
                stopTimer();
                totalTime += (endTime - startTime);
                countIterations++;
            }
        }
        long averageTime = totalTime / countIterations; // Вычисляем среднее время
        System.out.printf("  - время для списка из %d элементов: %d нс%n", smallSize, averageTime);

        ArrayList<Integer> largeList;
        totalTime = 0;
        countIterations = 0;
        while (countIterations < iterations) {
            largeList = new ArrayList<>(largeSize); // создаем ArrayList с 10 элементами
            for (int i = 0; i < largeSize; i++) {
                startTimer();
                largeList.add(i); // Тестируем производительность большого списка - добавляем элемент, не вызывая расширения капасити
                stopTimer();
                totalTime += (endTime - startTime);
                countIterations++;
            }
        }
        averageTime = totalTime / countIterations; // Вычисляем среднее время
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", largeSize, averageTime);
    }

    /**
     * Метод add() с расширением CAPACITY
     */
    public static void addWithExpansion() {
        System.out.println("Метод add() с расширением CAPACITY:");

        // Используем более малые коллекции
        int smallSize = 10;
        int largeSize = 100000;
        int iterations = 10000;

        // Измеряем для небольшого списка
        ArrayList<Integer> smallList;
        long totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            smallList = createList(smallSize); // заполняем до предела капасити
            startTimer();
            smallList.add(1); // добавляем +1 элемент для расширения капасити
            stopTimer();
            totalTime += (endTime - startTime);
        }
        long averageTime = totalTime / iterations; // Вычисляем среднее время
        System.out.printf("  - время для списка из %d элементов: %d нс%n", smallSize, averageTime);

        // Измеряем для большого списка
        ArrayList<Integer> largeList;
        totalTime = 0;
        for (int i = 0; i < iterations; i++) {
            largeList = createList(largeSize); // заполняем до предела капасити
            startTimer();
            largeList.add(1); // добавляем +1 элемент для расширения капасити
            stopTimer();
            totalTime += (endTime - startTime);
        }
        averageTime = totalTime / iterations; // Вычисляем среднее время
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", largeSize, averageTime);
    }

    /**
     * Метод для создания и заполнения списка с заданным количеством элементов
     */
    private static ArrayList<Integer> createList(int size) {
        ArrayList<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    private static void startTimer() {
        startTime = System.nanoTime();
    }

    private static void stopTimer() {
        endTime = System.nanoTime();
    }

}
