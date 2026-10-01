package com.prosoft.demo;

import java.io.File;
import java.io.IOException;

/**
 * Пример 8. Класс File
 */
public class FileClassDemo {

    public static void main(String[] args) {

        File dir = new File("testDir");
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            System.out.println("Папка создана " + created);
        }

        /**
         * Вывод содержимого каталога
         */
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName() + " " + (f.isFile() ? "файл" : "директория" ) );
            }
        }

        /**
         * Проверка существования файла
         */
        File file = new File("testDir/1.txt");
        System.out.println("Файл существует? : " + file.exists());
        if (file.exists()) {
            System.out.println("Размер файла: " + file.length());
        }

        /**
         * Создание файла
         */
        File file2 = new File("testDir/2.txt");
        try {
            boolean created = file2.createNewFile();
            System.out.println("Файл создан: " + created);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }



}
