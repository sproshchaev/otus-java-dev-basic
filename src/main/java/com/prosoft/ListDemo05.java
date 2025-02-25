package com.prosoft;

import java.util.ArrayList;
import java.util.Arrays;

public class ListDemo05 {
    public static void main(String[] args) {

        /**
         * Особенности работы с ArrayList
         * (1) Обращение к несуществующему объекту по индексу вызывает IndexOutOfBoundsException
         */
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apricot", "Banana"));
        System.out.println("Первоначальный список: " + list);
        try {
            String item = list.get(100); // Индекса 100 не существует
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }

        /**
         * (2) Попытка получить объект из пустого списка вызывает исключение, а не возвращает null
         */
        ArrayList<String> emptyList = new ArrayList<>(); // Создание пустого списка
        try {
            String item = emptyList.get(5); // Список пуст, индекс 5 не существует
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }
        emptyList.add(null); // Чтобы получить `null`, его нужно положить в список
        System.out.println("Элемент на индексе 0: " + emptyList.get(0));

        /**
         * (3) При удалении объекта из середины списка элементы сдвигаются влево
         */
        list.add("Cherry");
        System.out.println("До удаления: " + list);
        list.remove(1); // Удаляем элемент на индексе 1
        System.out.println("После удаления элемента 'Banana': " + list);

        /**
         * (4) При добавлении элемента в начало/середину элементы сдвигаются вправо
         */
        System.out.println("До добавления: " + list);
        list.add(0, "Apple"); // Добавляем элемент в начало
        System.out.println("После добавления в начало: " + list);
        list.add(2, "Blueberry"); // Добавляем элемент в середину
        System.out.println("После добавления в середину: " + list);

        /**
         * (5) Нельзя добавлять элемент по индексу, “перепрыгивая” ячейки
         */
        System.out.println("До добавления: " + list);
        try {
            list.add(10, "Banana"); // Пытаемся добавить элемент на несуществующий индекс 10
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }
    }
}
