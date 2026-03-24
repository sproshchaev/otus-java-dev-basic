package com.prosoft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class PrintWriterDemo {

    public static void main(String[] args) {

        try (PrintWriter pw = new PrintWriter("2-3.txt", StandardCharsets.UTF_8)) {
            String strForWrite = "Hello World! Привет Мир!";
            pw.println(strForWrite);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
