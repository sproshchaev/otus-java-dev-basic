package ru.otus;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 22-05-2025
 * <p>
 * Пример записи строки в файл. Кириллица будет отображаться не корректно, так как мы не указываем кодировку.
 */
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("2.txt")) {
            for (char ch : "Hello World! Привет, Мир!".toCharArray()) {
                fileOutputStream.write(ch);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
