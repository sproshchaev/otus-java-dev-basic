package ru.otus.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Чтобы указать кодировку, нужно использовать OutputStreamWriter в сочетании с PrintWriter`.
 */
public class PrintWriterDemo2 {

    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("2-3.txt"), StandardCharsets.UTF_8))) {
            String strForWrite = "Hello World! Привет Мир!";
            printWriter.print(strForWrite);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
