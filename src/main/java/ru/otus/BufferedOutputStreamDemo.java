package ru.otus;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 09-07-2025
 * <p>
 * Указываем кодировку - кириллица отображается корректно.
 */
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("2-2.txt"))) {
            String strForWrite = "Hello World! Привет Мир!";
            bufferedOutputStream.write(strForWrite.getBytes(StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
