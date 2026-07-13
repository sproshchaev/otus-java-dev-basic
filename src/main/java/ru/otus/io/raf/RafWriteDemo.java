package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 1. Запись в файл в режиме "rw".
 * Создаём файл и записываем данные через RandomAccessFile в режиме чтения-записи.
 */
public class RafWriteDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "rw")) {
            raf.writeBytes("0123456789ABCDEFGHIJ");
            System.out.println("Файл записан. Длина: " + raf.length() + " байт");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
