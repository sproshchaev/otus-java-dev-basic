package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 7. Строки в бинарном файле: writeUTF/readUTF.
 * Правильно сохраняем и читаем строки — в том числе с кириллицей.
 */
public class RafUtfStringsDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-strings.bin", "rw")) {
            raf.writeUTF("Привет");
            raf.writeUTF("RandomAccessFile");

            raf.seek(0);
            System.out.println(raf.readUTF());
            System.out.println(raf.readUTF());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
