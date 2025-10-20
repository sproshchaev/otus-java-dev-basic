package com.prosoft;

/**
 * Открытый урок JavaRush: циклы и массивы
 */
public class Main {

    public static void main(String[] args) {

        // Поиск максимального значения в массиве

        int[] temperature = {-5, 3, 12, -2};

        // инициализация итогового значения первым элементом
        int maxTemp = temperature[0];

        for (int i =0; i < temperature.length; i++) {

            // проверяю не больше ли текущий элемент?
            if (temperature[i] > maxTemp) {
                maxTemp = temperature[i];
            } // if

        } // for

        System.out.println("Максимальная температура = " + maxTemp);


    }


}