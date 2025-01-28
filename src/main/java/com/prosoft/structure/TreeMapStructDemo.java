package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.TreeMap;

public class TreeMapStructDemo {

    public static void main(String[] args) {

        // Создание пустого TreeMap
        TreeMap<String, Integer> emptyMap = new TreeMap<>();
        Ljv.browse(emptyMap);

        // Создание и заполнение TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Apple", 5);
        treeMap.put("Banana", 3);
        treeMap.put("Cherry", 8);
        Ljv.browse(treeMap);
    }
}
