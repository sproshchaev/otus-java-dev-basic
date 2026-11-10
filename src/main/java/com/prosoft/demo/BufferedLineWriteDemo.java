package com.prosoft.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedLineWriteDemo {

    public static void main(String[] args) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt", StandardCharsets.UTF_8))) {

            writer.write("Первая строка");
            writer.newLine();

            writer.write("2-я строка\n");

            writer.write("3-я строка");
            writer.newLine();

            System.out.println("Отчет записан! ");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
