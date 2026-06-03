package com.prosoft;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ByteWriteBlockDemo {

    public static void main(String[] args) {

        String str = "Hello World";

        try (FileOutputStream out = new FileOutputStream(
                "out2.txt")) {

            byte[] buffer = str.getBytes(StandardCharsets.UTF_8);
            out.write(buffer); // вместо цикла for - один вызов!

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
