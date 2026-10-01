package com.prosoft.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/***
 * Пример 2. Чтение блоками через массив с указанием кодировки
 */
public class ByteReadBlockDemo {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("demo.txt")) {

            byte[] buf = new byte[64];

            int n = in.read(buf);
            while (n > 0) {
                System.out.print(new String(buf, 0, n, StandardCharsets.UTF_8));
                n = in.read(buf);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
