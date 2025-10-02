package com.prosoft;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 03. Буферизованное чтение
 */
public class Example03 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("demo.txt");
             BufferedInputStream in = new BufferedInputStream(fis)) {

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
