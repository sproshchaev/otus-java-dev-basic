package ru.otus;

import java.io.*;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * PrintWriter по умолчанию использует кодировку системы и не поддерживает указание кодировки напрямую через свои конструкторы.
 *
 */
public class PrintWriterDemo {

    public static void main(String[] args) {
        try (PrintWriter printWriter = new PrintWriter("2-3.txt")) {
            String strForWrite = "Hello World! Привет Мир!";
            printWriter.print(strForWrite);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
