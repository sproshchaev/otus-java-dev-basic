package com.prosoft.demo;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharFileWriteDemo {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("notes.txt", StandardCharsets.UTF_8)) {

            writer.write("Привет, символьные потоки!");
            writer.write('\n'); // символ перевода строки
            writer.write("Вторая строка");
            System.out.println("Текст записан в файл notes.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
