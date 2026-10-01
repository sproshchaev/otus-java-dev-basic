package com.prosoft.demo;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Пример 1. Побайтовое чтение (медленное)
 */
public class ByteReadOneByOneDemo {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("demo.txt")) {

            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
