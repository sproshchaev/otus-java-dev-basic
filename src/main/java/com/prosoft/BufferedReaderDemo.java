package com.prosoft;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedReaderDemo {

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("1.txt", StandardCharsets.UTF_8))) {

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                System.out.println(str);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
