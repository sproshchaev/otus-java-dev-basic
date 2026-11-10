package com.prosoft.demo;

import java.io.IOException;
import java.io.PrintWriter;

public class FormattedWriteDemo {

    public static void main(String[] args) {

        try (PrintWriter writer = new PrintWriter("summary.txt")) {

            writer.println("Отчет по студентам");
            // %s - строка %d - целое число %n - перевод строки
            writer.printf("Имя: %s, возраст: %d%n", "Иван", 25);
            // %.2f - дробное число с 2-мя знаками
            writer.printf("Средний балл: %.2f%n", 4.756);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
