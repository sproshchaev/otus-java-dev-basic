package com.prosoft;

import java.util.ArrayList;

public class ListDemo06 {

    public static void main(String[] args) {

        /**
         * Время выполнения методов ArrayList: get() - доступ к элементу по индексу O(1) (постоянное время)
         * Формула: Адрес элемента = базовый адрес + (индекс × размер элемента),
         * где: Базовый адрес — это адрес первого элемента массива в памяти
         *      Индекс — это положение элемента в массиве, начиная с 0
         *      Размер элемента — это количество байт, необходимое для хранения одного элемента
         */
        ArrayList<String> list = new ArrayList<>();
        long startTime, endTime;
        String item;
        final long ONE_MILLION = 1_000_000; // число элементов и итераций
        list.add("Apple");

        // Измерение времени одного вызова ненадежно - лучше выполнить доступ 1 миллион раз и измерить среднее время
        startTime = System.nanoTime();
        for (int i = 0; i < ONE_MILLION; i++) {
            item = list.get(0);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время доступа к одному элементу: " + (endTime - startTime) / ONE_MILLION + " нс");

        for (int i = 0; i < ONE_MILLION; i++) { // + 1 млн элементов
            list.add("Apple " + i);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < ONE_MILLION; i++) {
            item = list.get(500_000);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время доступа к элементу среди миллиона: " + (endTime - startTime) / ONE_MILLION + " нс");
    }

}
