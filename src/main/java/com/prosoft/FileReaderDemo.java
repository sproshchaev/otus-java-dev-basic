package com.prosoft;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReaderDemo {

    public static void main(String[] args) {

        try (FileReader fileReader = new FileReader("1.txt", StandardCharsets.UTF_8)) {
            int bytesRead;
            while((bytesRead = fileReader.read()) != -1) {
                System.out.print((char) bytesRead);
            }
        } catch (IOException e) {
            System.out.println("Error opening file: "  + e.getMessage());
        }
    }
}
