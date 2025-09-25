package com.prosoft;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {

        Set<String> hashSet = new HashSet<>();
        hashSet.add("1");
        hashSet.add("1");  // Если добавляем то, что уже есть то коллекция не изменяется
        hashSet.add("2");
        hashSet.add("3");
        System.out.println("hashSet: " + hashSet  + "\n");

        /**
         * HashSet: размер структуры
         */
        System.out.println("size: " + hashSet.size() + "\n");

        // Использование iterator-а для перебора HashSet
        Iterator<String> itr3 = hashSet.iterator();
        while (itr3.hasNext()) {
            System.out.println("value " + itr3.next());
        }

        // for-each для перебора элементов
        for (String str : hashSet) {
            System.out.println(str);
        }
        System.out.println("");

        // метод remove() для удаления элемента
        System.out.println("remove: " + hashSet.remove("3")); // true
        System.out.println("hashSet: " + hashSet + "\n");

        // метод .contains() позволяет проверить наличие элемента
        System.out.println("contains: " + hashSet.contains("2") + "\n"); // true

        // метод .clear() удаляет все элементы
        hashSet.clear();
        System.out.println("clear: " + hashSet  + "\n");

        // isEmpty() проверяет структуру на пустоту
        System.out.println("isEmpty: " + hashSet.isEmpty()); // true

    }

}
