package com.prosoft.demo;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Пример 7. Буф. запись + flush
 */
public class BufferedWriteDemo {


    public static void main(String[] args) {

        String data = "Привет, Java!";

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out1.txt"))) {

            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);

            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
                out.flush(); // принудительный сброс
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
