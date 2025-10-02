package com.prosoft;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 05. Побайтовая запись в файл
 */
public class Example05 {

    public static void main(String[] args) {
        String data = "0123456789 Hello, World! Привет, Мир!";

        try(FileOutputStream out = new FileOutputStream("out.txt")) {

            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
