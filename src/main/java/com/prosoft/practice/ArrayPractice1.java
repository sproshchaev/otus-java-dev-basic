package com.prosoft.practice;

/**
 *  1) Вывод всех элементов массива
 */
public class ArrayPractice1 {
    public static void main(String[] args) {
        // Создаем массив
        int[] scores = {85, 92, 78, 96, 88};

        System.out.println("Оценки студентов:");

        // Способ 1: Традиционный for цикл
        System.out.println("Через традиционный for:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("Студент " + (i + 1) + ": " + scores[i]);
        }

        System.out.println();

        // Способ 2: For-each цикл (расширенный for)
        System.out.println("Через for-each:");
        int studentNumber = 1;
        for (int score : scores) {
            System.out.println("Студент " + studentNumber + ": " + score);
            studentNumber++;
        }
    }
}
