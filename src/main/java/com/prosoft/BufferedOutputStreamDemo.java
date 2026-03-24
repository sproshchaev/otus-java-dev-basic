package com.prosoft;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedOutputStreamDemo {
    public static void main(String[] args) {

        try (BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("2-2.txt"))) {

            String strForWrite = "This is a string! Это строка!";
            bufferedOutputStream.write(strForWrite.getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
