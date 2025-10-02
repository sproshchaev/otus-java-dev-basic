package com.prosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 06. Запись в файл через байтовый массив
 */
public class Example06 {

    public static void main(String[] args) {
        String data = "Hello World! Привет Мир! 0123456789";
        try (FileOutputStream out = new FileOutputStream("out.txt")) {

            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            out.write(bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
