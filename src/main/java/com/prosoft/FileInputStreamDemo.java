package com.prosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileInputStreamDemo {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {

            int bytesRead;
            while((bytesRead = fileInputStream.read()) != -1) {
                System.out.print((char) bytesRead);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("---");
        //
        try(FileInputStream fileInputStream = new FileInputStream("1.txt")) {

            byte[] bytes = new byte[1024];
            int bytesRead;
            while((bytesRead = fileInputStream.read(bytes)) != -1) {
                String data = new String(bytes,0,bytesRead, StandardCharsets.UTF_8);
                System.out.print(data);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //
        System.out.println("\n-------");

        try(FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            byte[] bytes = fileInputStream.readAllBytes();
            String data = new String(bytes,0, bytes.length, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
