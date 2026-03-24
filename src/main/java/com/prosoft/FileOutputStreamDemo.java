package com.prosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamDemo {

    public static void main(String[] args) {

        try(FileOutputStream fileOutputStream = new FileOutputStream("2.txt")) {
            for (char ch : "Hello World! Привет Мир!".toCharArray()) {
                fileOutputStream.write(ch);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
        try (FileOutputStream fileOutputStream = new FileOutputStream("2.txt")) {
            String str = "Hello World! Привет Мир!";
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



}
