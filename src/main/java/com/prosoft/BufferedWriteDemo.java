package com.prosoft;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class BufferedWriteDemo {

    public static void main(String[] args) {

        String str = "Hello World";

        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream("out3.txt")
        )) {

            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }

            // out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
