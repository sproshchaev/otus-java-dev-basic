package com.prosoft.practice;

/**
 * 3) Поиск максимального значения
 */
public class ArrayPractice3 {

    public static void main(String[] args) {
        int[] temperatures = {-5, 3, 12, 8, -2, 15, 7};

        // Предполагаем, что первый элемент - максимальный
        int maxTemp = temperatures[0];

        System.out.println("Температуры за неделю:");
        for (int i = 0; i < temperatures.length; i++) {
            System.out.println("День " + (i + 1) + ": " + temperatures[i] + "°C");

            // Проверяем, не больше ли текущий элемент
            if (temperatures[i] > maxTemp) {
                maxTemp = temperatures[i];
            }
        }

        System.out.println("Максимальная температура: " + maxTemp + "°C");
    }
}


