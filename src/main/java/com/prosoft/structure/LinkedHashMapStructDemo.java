package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.LinkedHashMap;

public class LinkedHashMapStructDemo {

    public static void main(String[] args) {

        // Создание пустого LinkedHashMap
        LinkedHashMap<String, Integer> emptyMap = new LinkedHashMap<>();
        Ljv.browse(emptyMap);

        // Создание и заполнение LinkedHashMap
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("One", 1);
        linkedHashMap.put("Two", 2);
        Ljv.browse(linkedHashMap);
    }
}