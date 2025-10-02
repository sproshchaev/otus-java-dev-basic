package com.prosoft;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 02. Чтение текстового файла через массив
 */
public class Example02 {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("demo.txt")) {

            byte[] buffer = new byte[64];
            int n = in.read(buffer);

            while (n > 0) {
                System.out.println("Прочитали: " + n + " из 64");
                System.out.println(new String(buffer, 0, n));
                n = in.read(buffer);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
