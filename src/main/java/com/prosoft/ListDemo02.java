package com.prosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo02 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("A");
        }
        for (int i = 0; i < 4; i++) {
            list.add("B");
        }
        for (int i = 0; i < 4; i++) {
            list.add("C");
        }
        System.out.println(list);

        // Заполнение через одну строку
        List<String> list2 = Arrays.asList("A", "B", "C");
        System.out.println(list2);
    }

}
