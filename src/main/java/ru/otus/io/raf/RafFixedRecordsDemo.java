package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 8. Доступ к записи по номеру: записи фиксированной длины.
 * Можно мгновенно прыгнуть к нужной записи, зная её номер.
 */
public class RafFixedRecordsDemo {
    private static final int RECORD_SIZE = 8; // размер одного double в байтах

    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-records.bin", "rw")) {
            // Записываем 5 значений подряд
            double[] values = {10.5, 20.5, 30.5, 40.5, 50.5};
            for (double v : values) {
                raf.writeDouble(v);
            }

            // Сразу прыгаем к записи с индексом 3, не читая предыдущие
            int index = 3;
            raf.seek((long) index * RECORD_SIZE);
            System.out.println("Запись №" + index + ": " + raf.readDouble());

            // И к записи с индексом 1
            index = 1;
            raf.seek((long) index * RECORD_SIZE);
            System.out.println("Запись №" + index + ": " + raf.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
