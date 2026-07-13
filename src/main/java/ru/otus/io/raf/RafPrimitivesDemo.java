package ru.otus.io.raf;

import java.io.RandomAccessFile;
import java.io.IOException;

/**
 * Пример 6. Запись и чтение примитивов: writeInt/readInt, writeDouble/readDouble.
 * RandomAccessFile реализует DataInput и DataOutput, поэтому умеет писать и читать
 * примитивные типы напрямую.
 */
public class RafPrimitivesDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("raf-primitives.bin", "rw")) {
            // Запись примитивов
            raf.writeInt(42);
            raf.writeDouble(3.14);
            raf.writeBoolean(true);

            // Возвращаемся в начало и читаем в том же порядке
            raf.seek(0);
            System.out.println("int:     " + raf.readInt());
            System.out.println("double:  " + raf.readDouble());
            System.out.println("boolean: " + raf.readBoolean());

            System.out.println("Размер файла: " + raf.length() + " байт");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
