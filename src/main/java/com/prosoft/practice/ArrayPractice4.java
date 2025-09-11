package com.prosoft.practice;

/**
 * 4) Подсчет элементов по условию
 */
public class ArrayPractice4 {
    public static void main(String[] args) {
        int[] ages = {25, 17, 34, 16, 28, 19, 42, 15, 31};
        int adultCount = 0;  // Счетчик взрослых (18+)
        int minorCount = 0;  // Счетчик несовершеннолетних

        System.out.println("Возраст участников:");
        for (int i = 0; i < ages.length; i++) {
            System.out.println((i + 1) + ". " + ages[i] + " лет");

            // Проверяем условие
            if (ages[i] >= 18) {
                adultCount++;
            } else {
                minorCount++;
            }
        }

        System.out.println("Взрослых: " + adultCount);
        System.out.println("Несовершеннолетних: " + minorCount);
    }
}
