package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 5. Изменение данных на месте (перезапись).
 * Меняем кусок в середине файла, не переписывая его целиком.
 */
public class RafOverwriteDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-overwrite.txt", "rw")) {
            raf.writeBytes("Version: 1.0");

            // Меняем только цифру версии, не трогая остальной текст
            raf.seek(9);            // позиция символа '1'
            raf.writeBytes("2");    // перезаписываем его на '2'

            // Читаем результат целиком
            raf.seek(0);
            byte[] buffer = new byte[(int) raf.length()];
            raf.readFully(buffer);
            System.out.println(new String(buffer));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
