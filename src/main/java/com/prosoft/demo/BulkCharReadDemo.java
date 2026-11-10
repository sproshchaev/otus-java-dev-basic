package com.prosoft.demo;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BulkCharReadDemo {

    public static void main(String[] args) {

        try (FileReader reader = new FileReader("notes.txt", StandardCharsets.UTF_8)) {

            char[] buffer = new char[16];
            int count;
            // Returns: The number of characters read, or -1 if the end of the stream has been reached
            while ((count = reader.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, count));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
