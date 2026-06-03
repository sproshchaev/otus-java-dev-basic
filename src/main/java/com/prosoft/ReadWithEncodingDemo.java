package com.prosoft;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadWithEncodingDemo {

    public static void main(String[] args) {

        try (InputStreamReader in = new InputStreamReader(
                new FileInputStream("demo.txt"),
                        StandardCharsets.UTF_8)) {

            int n = in.read();
            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
