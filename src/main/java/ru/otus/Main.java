package ru.otus;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        // Чтение файла по байтам
        try (FileInputStream in = new FileInputStream("demo.txt")) {

            int readByte = in.read();
            while (readByte != -1) {
                System.out.print((char) readByte);
                readByte = in.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n-----------");

        // Чтение файла через массив
        try (FileInputStream in = new FileInputStream("demo.txt")) {

            byte[] buf = new byte[64];

            int readByte = in.read(buf);
            while (readByte > 0) {
                System.out.println("Прочитали: " + readByte);
                System.out.print(new String(buf, 0, readByte)); // корректно прочитали кириллицу
                readByte = in.read(buf);
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }

        System.out.println("\n-----------");

        // Буферизированное чтение
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("demo.txt"))) {

            int readByte = in.read();
            while (readByte != -1) {
                System.out.print((char) readByte); // например A = 65
                readByte = in.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n-----------");

        // Чтение с учетом кодировки
        //                                         A        65
        try (InputStreamReader in = new InputStreamReader(new FileInputStream("demo.txt"))) {
            int readByte = in.read();
            while (readByte != -1) {
                System.out.print((char) readByte);
                readByte = in.read();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Побайтовая запись в файл
        String data = "Hello, World! = Привет, Мир!";
        try (FileOutputStream out = new FileOutputStream("out.txt")) {


            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                out.write(buffer[i]);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Запись в файл через байтовый массив
        // String data = "Hello, World!";
        try (FileOutputStream outputStream = new FileOutputStream("out2.txt")) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            outputStream.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Буферизированная запись в файл
        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("out3.txt"))) {
            byte[] buffer = data.getBytes(StandardCharsets.UTF_8);
            for (int i = 0; i < buffer.length; i++) {
                outputStream.write(buffer[i]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n-----------");

        // Примеры работы с основными методами класса File

        String filePath = "demo.txt";
        File file = new File(filePath);

        if (file.exists()) {
            System.out.println("Файл/дир существует: " + filePath);
        } else {
            System.out.println("Файл/дир не существует: " + filePath);
        }

        // Получить имя файла или каталога
        System.out.println("Имя файла/дир: " + file.getName());

        String parentDir = file.getParent();
        if (parentDir != null) {
            System.out.println("Род кат: " + parentDir);
        } else {
            System.out.println("Нет родительского каталога!");
        }

    }

}
