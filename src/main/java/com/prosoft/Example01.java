package com.prosoft;

import javax.imageio.IIOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 01. Побайтовое чтение текстового файла
 */
public class Example01 {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("demo.txt")) {
            int n = in.read();
            while(n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
