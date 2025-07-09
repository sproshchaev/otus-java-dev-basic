package ru.otus;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 15-04-2025
 * <p>
 * У нас нет Ридера и кириллица не прочитается корректно.
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("1.txt"))) {
            int bytesRead;
            while ((bytesRead = bufferedInputStream.read()) != -1) {
                System.out.print((char) bytesRead);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
