package com.prosoft;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteReadBlockDemo {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("demo.txt")) {

            byte[] buf = new byte[64];
            int n = in.read(buf);
            while (n > 0) {
                // System.out.print((char) n);
                System.out.print(new String(buf, 0, n));
                n = in.read(buf);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
