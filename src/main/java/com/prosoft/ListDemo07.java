package com.prosoft;

import java.util.ArrayList;

public class ListDemo07 {

    public static void main(String[] args) {

        /**
         * Время выполнения методов ArrayList: contains() - проверка наличия элемента в списке O(n) (линейное время)
         * Формула: Для поиска элемента в ArrayList метод contains() начинает с первого элемента и поочередно сравнивает
         * каждый элемент списка с искомым, пока не найдет совпадение или не дойдет до конца списка.
         * В худшем случае, если элемент не найден или находится в конце списка, необходимо проверить все n элементов.
         * Где:
         *      n — количество элементов в списке (ArrayList).
         */
        ArrayList<String> list = new ArrayList<>();
        long startTime, endTime;
        String item;
        list.add("Apple");
        final int ONE_MILLION = 1_000_000;
        final int ITERATIONS = 1_000; // число замеров

        // Измерение времени работы contains() для одного элемента
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            item = "Apple";
            list.contains(item);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время вызова contains() для одного элемента: " + (endTime - startTime) / ITERATIONS + " нс");

        for (int i = 0; i < ONE_MILLION; i++) { // + 1 млн элементов
            list.add("Apple " + i);
        }
        // Измерение времени работы contains() для элемента среди миллиона
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.contains("Apple 500000");
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время вызова contains() для элемента среди миллиона: " + (endTime - startTime) / ITERATIONS + " нс");

    }

}
