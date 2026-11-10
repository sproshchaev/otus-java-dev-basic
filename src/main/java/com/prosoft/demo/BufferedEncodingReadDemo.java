package com.prosoft.demo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Чаще всего используется так
 */
public class BufferedEncodingReadDemo {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("utf8.txt"), StandardCharsets.UTF_8))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
