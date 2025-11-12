package ru.otus.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Java IO. Часть 2 \\ ДЗ (12-11-2025)
 */
public class Main {

    public static void main(String[] args) {

        // Чтение символьного потока
        try (FileReader fileReader = new FileReader("1.txt")) {
            int byteRead;
            while ((byteRead = fileReader.read()) != -1) {  // 1 0 0 0 0 0 0 1 = A = 65
                System.out.print((char) byteRead); // 65
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Запись символьного потока
        try (FileWriter fileWriter = new FileWriter("2.txt", StandardCharsets.ISO_8859_1)) {
            fileWriter.write("0123456789\n");
            fileWriter.write("йцукенгшщз\n");
            fileWriter.write("qwertyuiop\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");

        // RandomAccessFile
        try (RandomAccessFile randomAccessFile = new RandomAccessFile("3.txt", "rw")) {
            randomAccessFile.seek(5);
            System.out.println((char) randomAccessFile.read()); // 66 -> B
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");

        // Сериализация
        Book book = new Book(1L, "Title", "Author");

        // book => "book.ser": 1 01 0 1 00  000

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("book.ser"))) {
            objectOutputStream.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Мы файл передаем в любое место
        Book bookClone = null;

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("book.ser"))) {
            bookClone = (Book) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookClone); // Book{id=1, title='Title', author='Author'}

    }

}