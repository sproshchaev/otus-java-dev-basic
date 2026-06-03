package com.prosoft;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedReadDemo {

    public static void main(String[] args) {

        try (BufferedInputStream in = new BufferedInputStream(
                new FileInputStream("demo.txt")
        )) {

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
