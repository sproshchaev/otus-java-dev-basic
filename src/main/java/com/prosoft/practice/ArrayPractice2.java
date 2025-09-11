package com.prosoft.practice;

/**
 *  2) Поиск суммы элементов
 */
public class ArrayPractice2 {
    public static void main(String[] args) {
        int[] prices = {150, 200, 75, 300, 125};
        int total = 0;

        System.out.println("Цены товаров:");
        // Подсчитываем сумму
        for (int i = 0; i < prices.length; i++) {
            System.out.println((i + 1) + ". " + prices[i] + " руб.");
            total += prices[i];  // Прибавляем к общей сумме
        }

        System.out.println("Общая сумма: " + total + " руб.");
    }
}
