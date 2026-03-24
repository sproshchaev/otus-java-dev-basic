package com.prosoft;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

    public static void main(String[] args) {

        try (RandomAccessFile raf = new RandomAccessFile("4.txt", "rw")) {

            raf.seek(raf.length());
            raf.write(66);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
