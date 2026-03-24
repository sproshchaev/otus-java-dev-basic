package com.prosoft;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedInputStreamDemo {
    public static void main(String[] args) {

        try (BufferedInputStream bis = new  BufferedInputStream(new FileInputStream("1.txt"))) {
            int byteRead;
            while ((byteRead = bis.read()) != -1) {
                System.out.print((char) byteRead);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n---");

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("1.txt"))) {
            byte[] bytes = bis.readAllBytes();
            String str = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(str);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
