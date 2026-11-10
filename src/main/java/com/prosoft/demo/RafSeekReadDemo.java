package com.prosoft.demo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RafSeekReadDemo {

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "rw")) {
            raf.writeBytes("01234567890QWERTYUIOP");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // читаем символ с позиции 10
        try (RandomAccessFile raf = new RandomAccessFile("raf-demo.txt", "rw")) {
            raf.seek(10);
            System.out.println((char) raf.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
