package com.prosoft.practice;

/**
 * 3) Работа со строками
 */
public class VarargsPractice3 {
    // Метод, который объединяет все строки
    public static String joinStrings(String... strings) {
        if (strings.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (String str : strings) {
            result.append(str).append(" ");
        }
        return result.toString().trim(); // Убираем последний пробел
    }

    public static void main(String[] args) {
        System.out.println("Объединение слов: " +
                joinStrings("Привет", "мир", "Java"));
        System.out.println("Одно слово: " +
                joinStrings("Одиночество"));
        System.out.println("Без слов: '" +
                joinStrings() + "'");
    }
}
