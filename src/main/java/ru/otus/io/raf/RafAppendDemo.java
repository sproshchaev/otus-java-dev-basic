package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 4. Размер файла и добавление в конец: length() + seek(length()).
 * Узнаём размер файла и дописываем данные в конец существующего файла.
 */
public class RafAppendDemo {
    public static void main(String[] args) {
        // Создаём файл с одной строкой
        try (RandomAccessFile raf = new RandomAccessFile("raf-append.txt", "rw")) {
            raf.setLength(0);            // очищаем, если файл уже был
            raf.writeBytes("LINE-1\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Дописываем в конец уже существующего файла
        try (RandomAccessFile raf = new RandomAccessFile("raf-append.txt", "rw")) {
            System.out.println("Указатель при открытии: " + raf.getFilePointer());
            System.out.println("Длина файла: " + raf.length());
            raf.seek(raf.length());      // переходим в конец
            raf.writeBytes("LINE-2\n");
            System.out.println("Новая длина: " + raf.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
