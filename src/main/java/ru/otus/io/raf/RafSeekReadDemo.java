package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 2. Чтение с позиционированием: seek (пример со слайда).
 * Открываем файл только на чтение и читаем символ не с начала, а с позиции 10.
 */
public class RafSeekReadDemo {
    public static void main(String[] args) {
        // Подготовка: создаём файл в режиме "rw"
        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "rw")) {
            raf.writeBytes("0123456789ABCDEFGHIJ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // То, что на слайде: открываем только на чтение и читаем символ с позиции 10
        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "r")) {
            raf.seek(10);
            System.out.println((char) raf.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
