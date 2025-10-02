package com.prosoft;

import java.io.File;

/**
 * 08. Класс File: .getName()
 */
public class Example09 {

    public static void main(String[] args) {

        String filePath = "demo.txt";
        File file = new File(filePath);

        String fileName = file.getName();

        System.out.println("Имя файла или дир. " + fileName);

    }

}
