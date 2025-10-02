package com.prosoft;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 08. Класс File
 */
public class Example08 {

    public static void main(String[] args) {

        String filePath = "demo.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("Файл или дир. существует " + filePath);
        } else {
            System.out.println("Файл или дир. НЕ существует " + filePath);
        }

    }

}
