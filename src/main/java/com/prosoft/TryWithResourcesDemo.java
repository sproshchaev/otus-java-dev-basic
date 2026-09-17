package com.prosoft;

import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;

public class TryWithResourcesDemo {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("file.txt")) {

            // какой-то код

        } catch (IOException e) {
            System.out.println("Ошибка при записи файла!");
        }

    }

}
