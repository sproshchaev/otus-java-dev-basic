package com.prosoft;

import java.util.LinkedList;

public class LinkedListExample1 {

    public static void main(String[] args) {

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        System.out.println(linkedList);
        System.out.println("Первый элемент: " + linkedList.getFirst());
        System.out.println("Последний элемент: " + linkedList.getLast());

        linkedList.removeFirst();
        linkedList.removeLast();
        System.out.println(linkedList);

        System.out.println("Извлекаем: " + linkedList.pop());
        System.out.println(linkedList);

    }

}
