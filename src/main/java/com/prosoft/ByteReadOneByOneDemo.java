package com.prosoft;

import java.io.FileInputStream;
import java.io.IOException;

public class ByteReadOneByOneDemo {

    public static void main(String[] args) {

        try (FileInputStream in = new FileInputStream("demo.txt")) {

            // Reads a byte of data from this input stream. This method blocks if no input is yet available.
            // Returns: the next byte of data, or -1 if the end of the file is reached.
            // Throws: IOException – if an I/O error occurs.
            int n = in.read();

            while (n != -1) {
                System.out.print((char) n);
                n = in.read();
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
