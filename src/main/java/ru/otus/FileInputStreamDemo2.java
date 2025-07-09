package ru.otus;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 09-07-2025
 * <p>
 * FileInputStream - у нас в названии есть Stream и нет Reader, значит мы работаем с байтовым потоком.
 * В этом случае у нас будет корректно читаться ASCII и не будет читаться кириллица.
 * Для того чтобы корректно читать кириллицу, то необходимо обернуть поток в строку и указать кодировку.
 */
public class FileInputStreamDemo2 {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fileInputStream.read(buffer)) != -1) {
                String data = new String(buffer, 0, length, StandardCharsets.UTF_8);
                System.out.println(data);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
