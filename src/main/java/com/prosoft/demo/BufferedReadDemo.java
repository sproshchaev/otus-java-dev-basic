package com.prosoft.demo;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/***
 * Пример 3. Буферизированное чтение
 */
public class BufferedReadDemo {

    public static void main(String[] args) {


        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("demo.txt"))) {

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
