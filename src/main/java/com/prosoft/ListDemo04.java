package com.prosoft;

import java.util.LinkedList;

public class ListDemo04 {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new LinkedList<>();

        // add
        linkedList.add("1");
        linkedList.add("2");
        linkedList.add("3");

        System.out.println(linkedList);

        // добавление в начало и конец
        linkedList.addFirst("0");
        linkedList.addLast("4");
        System.out.println(linkedList);

        // get() получение элементов списка
        System.out.println(linkedList.get(2));

        // remove()
        System.out.println(linkedList.remove(1));
        System.out.println(linkedList);

        // set()
        linkedList.set(1, "2!");
        System.out.println(linkedList);

        // contains()
        System.out.println(linkedList.contains("2!!"));

        // clear()
        linkedList.clear();
        System.out.println(linkedList);




    }

}
