package com.prosoft.demo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RafWriteDemo {

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "rw")) {

            raf.writeBytes("01234567890ASDFGHJKL");
            System.out.println("Файл записан, длина: " + raf.length() + " байт");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
