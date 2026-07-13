package ru.otus.io.text;

import java.io.PrintWriter;
import java.io.IOException;

/**
 * Пример 10. Форматированный вывод в файл: PrintWriter.
 * Удобный вывод текста с форматированием — привычные println и printf, но в файл.
 */
public class FormattedWriteDemo {
    public static void main(String[] args) {
        try (PrintWriter writer = new PrintWriter("summary.txt")) {
            writer.println("Отчёт по студентам");
            writer.printf("Имя: %s, возраст: %d%n", "Иван", 25);
            writer.printf("Средний балл: %.2f%n", 4.756);
            System.out.println("Форматированный отчёт записан в summary.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
