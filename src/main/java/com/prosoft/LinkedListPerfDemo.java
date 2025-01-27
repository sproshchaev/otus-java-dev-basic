package com.prosoft;

import java.util.LinkedList;

/**
 * Демонстрация производительности методов класса LinkedList
 */
public class LinkedListPerfDemo {

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

        // Операции с постоянным временем O(1): addFirst(), addLast(), removeFirst(), removeLast(), getFirst(), getLast()
        addFirst();
        addLast();
        removeFirst();
        removeLast();
        getFirst();
        getLast();

        // Операции с линейным временем O(n): get(), set(), remove(), contains(), add()
        get();
        set();
        remove();
        contains();

        // Особенность метода add():
        //   - если добавление происходит в начало или конец списка, то O(1)
        add();
        //   - если добавление происходит по индексу или в произвольное место, то O(n)
        addAtIndex();
    }

    /**
     * Метод addFirst()
     */
    public static void addFirst() {
        System.out.println("Метод addFirst():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.addFirst(i); // Тестируем производительность малого списка - добавляем элемент в начало
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.addFirst(i); // Тестируем производительность большого списка - добавляем элемент в начало
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод addLast()
     */
    public static void addLast() {
        System.out.println("Метод addLast():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.addLast(i); // Тестируем производительность малого списка - добавляем элемент в конец
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.addLast(i); // Тестируем производительность большого списка - добавляем элемент в конец
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод removeFirst()
     */
    public static void removeFirst() {

        System.out.println("Метод removeFirst():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL); // Создаем LinkedList с 10 элементами
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            if (!smallList.isEmpty()) {
                smallList.removeFirst(); // Удаляем первый элемент, если список не пуст
            }
            smallList.addFirst(1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 20); // Создаем большой LinkedList с 50 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            if (!largeList.isEmpty()) {
                largeList.removeFirst(); // Удаляем первый элемент, если список не пуст
            }
            largeList.addFirst(1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 20, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод removeLast()
     */
    public static void removeLast() {
        System.out.println("Метод removeLast():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL); // Создаем LinkedList с 10 элементами
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            if (!smallList.isEmpty()) {
                smallList.removeLast(); // Удаляем последний элемент, если список не пуст
            }
            smallList.addLast(1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 20); // Создаем большой LinkedList с 50 000 элементов
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            if (!largeList.isEmpty()) {
                largeList.removeLast(); // Удаляем последний элемент, если список не пуст
            }
            largeList.addLast(1000);  // Восстанавливаем элемент, чтобы сохранить размер списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 20, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод getFirst()
     */
    public static void getFirst() {
        System.out.println("Метод getFirst():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.getFirst(); // Тестируем производительность небольшого списка - получаем первый элемент
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.getFirst(); // Тестируем производительность большого списка - получаем первый элемент
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод getLast()
     */
    public static void getLast() {
        System.out.println("Метод getLast():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.getLast(); // Тестируем производительность небольшого списка - получаем последний элемент
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.getLast(); // Тестируем производительность большого списка - получаем последний элемент
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод get()
     */
    public static void get() {
        System.out.println("Метод get():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.get(BASE_SIZE_SMALL / 2); // Тестируем производительность меньшего списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 10); // Уменьшаем размер коллекции
        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) { // Уменьшаем количество итераций
            largeList.get(largeList.size() / 2); // Тестируем производительность меньшего списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", largeList.size(), (endTime - startTime) / (ITERATIONS / 40));
    }

    /**
     * Метод set()
     */
    public static void set() {
        System.out.println("Метод set():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.set(BASE_SIZE_SMALL / 2, 1000); // Обновляем элемент в меньшем списке
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 10); // Уменьшаем размер коллекции
        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) { // Уменьшаем количество итераций
            largeList.set(largeList.size() / 2, 1000); // Обновляем элемент в меньшем списке
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 10, (endTime - startTime) / (ITERATIONS / 40));
    }

    /**
     * Метод remove()
     */
    public static void remove() {
        System.out.println("Метод remove():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            if (smallList.size() > 0) { // Проверка, что список не пуст
                smallList.remove(smallList.size() / 2); // Удаляем элемент по индексу
            }
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 10); // Создаём список для больших данных
        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) {
            if (largeList.size() > 0) { // Проверка, что список не пуст
                largeList.remove(largeList.size() / 2); // Удаляем элемент по индексу из середины
            }
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 10, (endTime - startTime) / (ITERATIONS / 40));
    }

    /**
     * Метод contains()
     */
    public static void contains() {
        System.out.println("Метод contains():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.contains(BASE_SIZE_SMALL / 2); // Проверяем наличие элемента в меньшем списке
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 10); // Уменьшаем размер коллекции
        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) { // Уменьшаем количество итераций
            largeList.contains(largeList.size() / 2); // Проверяем наличие элемента в меньшем списке
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", largeList.size(), (endTime - startTime) / (ITERATIONS / 40));
    }

    /**
     * Метод add() - добавляет элемент в конец списка (аналогично методу addLast())
     */
    public static void add() {
        System.out.println("Метод add():");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            smallList.add(i); // Добавляем элемент в конец меньшего списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / ITERATIONS);

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE);
        startTimer();
        for (int i = 0; i < ITERATIONS; i++) {
            largeList.add(i); // Добавляем элемент в конец большого списка
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE, (endTime - startTime) / ITERATIONS);
    }

    /**
     * Метод addAtIndex()
     */
    public static void addAtIndex() {
        System.out.println("Метод add() по индексу:");

        LinkedList<Integer> smallList = createList(BASE_SIZE_SMALL);
        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) {
            smallList.add(smallList.size() / 2, i); // Тестируем производительность малого списка - добавляем элемент в середину
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n", BASE_SIZE_SMALL, (endTime - startTime) / (ITERATIONS / 40));

        LinkedList<Integer> largeList = createList(BASE_SIZE_LARGE / 10);

        startTimer();
        for (int i = 0; i < ITERATIONS / 40; i++) {
            largeList.add(largeList.size() / 2, i); // Тестируем производительность большого списка - добавляем элемент в середину
        }
        stopTimer();
        System.out.printf("  - время для списка из %d элементов: %d нс%n%n", BASE_SIZE_LARGE / 10, (endTime - startTime) / (ITERATIONS / 40));
    }

    /**
     * Метод для создания и заполнения списка с заданным количеством элементов
     */
    private static LinkedList<Integer> createList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
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
