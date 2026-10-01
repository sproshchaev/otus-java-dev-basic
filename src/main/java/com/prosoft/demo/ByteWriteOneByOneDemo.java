package com.prosoft.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Пример 5. Побайтовая запись (медленно)
 */
public class ByteWriteOneByOneDemo {

    public static void main(String[] args) {

        String data = "Hello, Java! Привет, Java!";

        try (FileOutputStream out = new FileOutputStream("out1.txt")) {

            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);

            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
