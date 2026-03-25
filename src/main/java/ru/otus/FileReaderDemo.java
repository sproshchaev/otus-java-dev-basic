package ru.otus;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Демо FileReader
 */
public class FileReaderDemo {
    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("1.txt", StandardCharsets.UTF_8)) {

            // 1000001 -> 65 -> A
            int bytesRead; // 65
            while ((bytesRead = fileReader.read()) != -1) {

                System.out.print((char) bytesRead); // 65 -> 'A', 66 -> 'B' (далее по ASCII)

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
