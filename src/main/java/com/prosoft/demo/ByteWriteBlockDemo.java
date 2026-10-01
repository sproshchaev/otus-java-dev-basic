package com.prosoft.demo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/***
 * Пример 6. Запись через байтовый массив (высокая производительность)
 */
public class ByteWriteBlockDemo {

    public static void main(String[] args) {

        String data = "Привет, Java!";

        try (FileOutputStream out = new FileOutputStream("out1.txt")) {

            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
