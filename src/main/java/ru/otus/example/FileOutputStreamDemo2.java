package ru.otus.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Пример записи строки в файл. Используем Строку как обертку и укажем таблицу кодировки - и кириллица будет отображаться
 * корректно.
 */
public class FileOutputStreamDemo2 {

    public static void main(String[] args) {
        try (FileOutputStream fileOutputStream = new FileOutputStream("2.txt")) {
            String strForWrite = "Hello World! Привет Мир!";
            fileOutputStream.write(strForWrite.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
