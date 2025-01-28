package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.LinkedHashSet;

public class LinkedHashSetStructDemo {

    public static void main(String[] args) {

        // Создание пустого LinkedHashSet
        LinkedHashSet<String> emptySet = new LinkedHashSet<>();
        Ljv.browse(emptySet);

        // Создание и заполнение LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        Ljv.browse(linkedHashSet);
    }
}
