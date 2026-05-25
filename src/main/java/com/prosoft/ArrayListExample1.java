package com.prosoft;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListExample1 {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

        // for-i
        System.out.println("for-i: ");
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }

        // for-each
        System.out.println("for-each: ");
        for (String str : arrayList) {
            System.out.println(str);
        }

        System.out.println(arrayList);
        System.out.println("размер списка: " + arrayList.size());

        System.out.println("первый элемент: " + arrayList.get(0));
        System.out.println("второй элемент: " + arrayList.get(1));
        System.out.println("третий элемент: " + arrayList.get(2));

        arrayList.set(2, "3!");

        System.out.println("последний измененный элемент: " + arrayList.get(arrayList.size() - 1));

        arrayList.remove(arrayList.size() - 1);
        System.out.println(arrayList);

        boolean removed = arrayList.remove("2");
        System.out.println(removed);

        System.out.println(arrayList);

        System.out.println("Элемент '1' присутствует: " + arrayList.contains("1"));
        System.out.println("Элемент '2' присутствует: " + arrayList.contains("2"));

        arrayList.clear();

        System.out.println(arrayList);
        System.out.println("Размер массива: " + arrayList.size());

        //  Из массива в список
        String[] array = {"1", "2", "3"};
        ArrayList<String> listFromArray = new ArrayList<>(Arrays.asList(array));
        System.out.println("Список из массива: " + listFromArray);

        // Из списка в массив
        String[] newArray = listFromArray.toArray(new String[0]);
        System.out.println("Массив из списка: " + Arrays.toString(newArray));

        ArrayList<String> newArrayList = new ArrayList<>(); // Capacity = 10
        System.out.println("Размер: " + newArrayList.size());
        newArrayList.add(null);
        System.out.println("Элемент 1: " + newArrayList.get(0));


    }

}
