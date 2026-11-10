package com.prosoft.demo;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CharFileReadDemo {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("notes.txt", StandardCharsets.UTF_8)) {

            int c; // 65 -> 'А', 66 -> 'B'
            // Returns: The character read, or -1 if the end of the stream has been reached
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
