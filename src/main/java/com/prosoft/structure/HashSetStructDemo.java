package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.HashSet;

public class HashSetStructDemo {

    public static void main(String[] args) {

        // Создание пустого HashSet
        HashSet<String> emptySet = new HashSet<>();
        Ljv.browse(emptySet);

        // Создание и заполнение HashSet
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        Ljv.browse(hashSet);
    }
}
