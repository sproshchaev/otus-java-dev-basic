package com.prosoft;

import java.io.File;
import java.io.IOException;

public class FileClassDemo {

    public static void main(String[] args) throws IOException {

        File dir = new File("testDir");

        if (!dir.exists()) {
            boolean created = dir.mkdir();
            System.out.println("Directory created: " + created);
        }

        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName() + " " + (file.isFile() ? "файл" : "дир"));
            }
        }

        // Проверка существования файла
        File file = new File("testDir/file.txt");
        System.out.println("Файл существует? " + file.exists());
        System.out.println("Размер " + file.length());

        // Создание файла
        File file2 = new File("testDir/file2.txt");
        boolean created = file2.createNewFile();
        System.out.println("Файл создан? " + created);
        System.out.println("Файл существует? " + file2.exists());
        System.out.println("Размер " + file2.length());



    }

}
