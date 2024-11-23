package ru.otus;

import java.util.ArrayList;
import java.util.List;

/**
 * Java collections framework: List, LinkedList
 */
public class ListExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Строка_1");
        list.add("Строка_2");
        list.add("Строка_3");
        System.out.println(list);
    }

}
