package com.prosoft;

import java.io.File;

/**
 * 08. Класс File:
 */
public class Example11 {

    public static void main(String[] args) {

        // String directoryPath = "src\\subDir"; // для Windows
        // String directoryPath = "src//subDir"; // для Linux, macOS

        File path = new File("src", "subDir");
        String directoryPath = path.getAbsolutePath();
        System.out.println(directoryPath);

    }

}
