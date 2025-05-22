package ru.otus;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 22-05-2025
 * <p>
 * FileInputStream - у нас в названии есть Stream и нет Reader, значит мы работаем с байтовым потоком.
 * В этом случае у нас будет корректно читаться ASCII и не будет читаться кириллица.
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            int readByte;
            while ((readByte = fileInputStream.read()) != -1) {
                System.out.print((char) readByte);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


}
