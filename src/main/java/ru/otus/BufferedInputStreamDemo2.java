package ru.otus;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * Используем Cтроку как обертку над массивом байт - и кириллица отображается корректно.
 */
public class BufferedInputStreamDemo2 {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("1.txt"))) {
            byte [] bytes = bufferedInputStream.readAllBytes();
            String data = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
