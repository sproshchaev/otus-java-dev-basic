package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.TreeSet;

public class TreeSetStructDemo {

    public static void main(String[] args) {

        // Создание пустого TreeSet
        TreeSet<String> emptySet = new TreeSet<>();
        Ljv.browse(emptySet);

        // Создание и заполнение TreeSet
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Apple");
        treeSet.add("Banana");
        treeSet.add("Cherry");
        Ljv.browse(treeSet);
    }
}
