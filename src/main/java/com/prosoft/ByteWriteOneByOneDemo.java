package com.prosoft;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteWriteOneByOneDemo {

    public static void main(String[] args) {
        String str = "Hello World!";

        try (FileOutputStream out = new FileOutputStream("out1.txt")) {

            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
