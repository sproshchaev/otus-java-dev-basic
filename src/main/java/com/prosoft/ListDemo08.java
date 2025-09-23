package com.prosoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListDemo08 {

    public static void main(String[] args) {

        // Создаем ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Элемент 1");
        arrayList.add("Элемент 2");
        System.out.println("ArrayList: " + arrayList);

        // Создаем LinkedList
        List<String> linkedList = new LinkedList<>();
        linkedList.add("Элемент A");
        linkedList.add("Элемент B");
        System.out.println("LinkedList: " + linkedList);

        // Работа с элементами
        System.out.println("Первый элемент ArrayList: " + arrayList.get(0));
        System.out.println("Первый элемент LinkedList: " + linkedList.get(0));
    }

}
