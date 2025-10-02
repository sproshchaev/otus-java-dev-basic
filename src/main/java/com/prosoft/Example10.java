package com.prosoft;

import java.io.File;

/**
 * 08. Класс File: getParent()
 */
public class Example10 {

    public static void main(String[] args) {

        String filePath = "src\\main\\java\\com\\prosoft";
        File file = new File(filePath);

        String parentDirectory = file.getParent();

        if (parentDirectory != null) {
            System.out.println("Родительский каталог: " + parentDirectory);
        } else {
            System.out.println("Файл или дир. не имеет род. каталога!");
        }
    }

}
