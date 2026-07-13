package ru.otus.io.text;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * Пример 8. Почему кодировка важна: чтение UTF-8 в неверной кодировке.
 * Один и тот же файл в правильной и неправильной кодировке — откуда «кракозябры».
 */
public class WrongEncodingDemo {
    public static void main(String[] args) {
        System.out.println("== Читаем как UTF-8 ==");
        printFile(StandardCharsets.UTF_8);

        System.out.println("== Читаем как ISO-8859-1 ==");
        printFile(StandardCharsets.ISO_8859_1);
    }

    private static void printFile(Charset charset) {
        try (InputStreamReader reader =
                     new InputStreamReader(new FileInputStream("utf8.txt"), charset)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
