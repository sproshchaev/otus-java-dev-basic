package com.prosoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {

        // 1) add - добавление элемента в конец списка
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("A");
        }
        System.out.println(list); // [A, A, A, A]

        // 2) add(index, E)
        list.add(2, "B");
        System.out.println(list); // [A, A, B, A, A]

        // 3) get(index)
        System.out.println(list.get(2)); // B

        // 4) set(index, E)
        list.set(2, "С");
        System.out.println(list); // [A, A, С, A, A]

        // 5) remove(index)
        list.remove(2);
        System.out.println(list); // [A, A, A, A]

        // 6) remove(E)
        list.remove("A");
        System.out.println(list); // [A, A, A]

        boolean isRmoved = list.remove("C");
        System.out.println("Был удален? " + isRmoved); // Был удален? false

        // 7) size()
        System.out.println("Размер списка " + list.size()); // Размер списка 3

        // 8) ensureCapacity(cap) (по умолчанию DEFAULT_CAPACITY = 10)
        list.ensureCapacity(20);

        // 9) trimToSize: 20 -> 3
        list.trimToSize();

        // 10) contains()
        System.out.println("Есть элемент в списке? " + list.contains("W")); // Есть элемент в списке? false

        // Пример с листом Integer
        // ArrayList<Integer> integers = new ArrayList<>(List.of(1, 2, 3)); // Вариант инициализации листа
        ArrayList<Integer> integers = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            integers.add(i);
        }
                                      //  0  1  2  3
        System.out.println(integers); // [1, 2, 3, 4, 5, 6, 7, 8, 9]

        integers.remove(3);
        System.out.println(integers); // [1, 2, 3, 5, 6, 7, 8, 9]

        Integer intVar = Integer.parseInt("3");
        integers.remove(intVar);
        System.out.println(integers); // [1, 2, 5, 6, 7, 8, 9]

        // LinkedList
        System.out.println("LinkedList:");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.add(i);
        }
        System.out.println(linkedList); // [0, 1, 2, 3, 4]

        linkedList.addFirst(0);
        linkedList.addLast(4);
        System.out.println(linkedList); // [0, 0, 1, 2, 3, 4, 4]

        linkedList.clear();

        // Остальные методы аналогичны ArrayList


    }

}