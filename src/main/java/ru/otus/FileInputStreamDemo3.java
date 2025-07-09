package ru.otus;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * Занятие «Jаva IO. Часть 2 \\ ДЗ» 09-07-2025
 * <p>
 * FileInputStream - у нас в названии есть Stream и нет Reader, значит мы работаем с байтовым потоком.
 * В этом случае у нас будет корректно читаться ASCII и не будет читаться кириллица.
 * Для того чтобы корректно читать кириллицу, то необходимо обернуть поток в строку и указать кодировку.
 * <p>
 * Метод `readAllBytes()` из класса `InputStream` считывает все байты из входного потока в массив байтов.
 * Однако есть важные ограничения, которые следует учитывать:
 * 1. Размер файла ограничен максимальным размером массива в Java:
 *  - Максимальный размер массива в Java ограничен типом `int`, так как индексирование массива основано на 32-битных
 *     целых числах. Это означает, что теоретически можно считывать файл размером до 2,147,483,647 байт (2 ГБ)
 * 	- На практике попытка создания массива такого размера может быть ограничена доступной памятью JVM, что зависит
 * 	от настроек параметра `-Xmx`
 * 2. Ограничения по памяти:
 *     - Если файл слишком большой, например, превышает объем доступной оперативной памяти или размер памяти,
 *     выделенной JVM, метод вызовет `OutOfMemoryError`
 * 3. Практические рекомендации:
 *     - Если файл может быть большим, лучше использовать поблочное чтение данных (`read(byte[] b)` или `BufferedInputStream`)
 *     вместо `readAllBytes()`
 */
public class FileInputStreamDemo3 {

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {
            byte[] buffer = fileInputStream.readAllBytes();
            String data = new String(buffer, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
