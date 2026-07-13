package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 3. Указатель файла: getFilePointer().
 * Где находится указатель и как он двигается — сам при чтении и вручную при seek.
 */
public class RafFilePointerDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-pointer.txt", "rw")) {
            raf.writeBytes("0123456789");

            raf.seek(0);
            System.out.println("Позиция в начале: " + raf.getFilePointer());

            raf.read();
            System.out.println("После чтения 1 байта: " + raf.getFilePointer());

            raf.seek(5);
            System.out.println("После seek(5): " + raf.getFilePointer());
            System.out.println("Символ на позиции 5: " + (char) raf.read());
            System.out.println("После чтения на позиции 5: " + raf.getFilePointer());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
