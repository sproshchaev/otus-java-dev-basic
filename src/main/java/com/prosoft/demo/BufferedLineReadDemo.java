package com.prosoft.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedLineReadDemo {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("notes.txt", StandardCharsets.UTF_8))) {

            String line;
            // Returns: A String containing the contents of the line, not including any line-termination characters, or null if the end of the stream has been reached without reading any characters
            while ((line = reader.readLine()) != null ) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
