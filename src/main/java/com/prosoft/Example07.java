package com.prosoft;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 07. Буферизированная запись в файл
 */
public class Example07 {

    public static void main(String[] args) {
        String data = "Hello World! Привет Мир! 0123456789";
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"))) {

            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < bytes.length; i++) {
                out.write(bytes[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
