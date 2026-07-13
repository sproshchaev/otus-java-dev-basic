package ru.otus.io.text;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Пример 5. Буферизованная запись строк через BufferedWriter.
 * Запись текста построчно с буферизацией и корректным переводом строки.
 */
public class BufferedLineWriteDemo {
    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"))) {
            writer.write("Первая строка отчёта");
            writer.newLine();
            writer.write("Вторая строка отчёта");
            writer.newLine();
            System.out.println("Отчёт записан в report.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
