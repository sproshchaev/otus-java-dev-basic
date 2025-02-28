package com.prosoft;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapDemo {

    public static void main(String[] args) {

        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");

        // использование итератора для .entrySet()
        Iterator<Map.Entry<Integer, String>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("");

        // использование итератора для .keySet()
        Iterator<Integer> itr2 = linkedHashMap.keySet().iterator();
        while(itr2.hasNext()) {
            System.out.println("key " + itr2.next());
        }
        System.out.println("");

        // использование итератора для .values()
        Iterator<String> itr3 = linkedHashMap.values().iterator();
        while (itr3.hasNext()) {
            System.out.println("value " + itr3.next());
        }
        System.out.println("");

        // перебор элементов через for-each и .entrySet()
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("key " + entry.getKey() + " value " + entry.getValue());
        }
        System.out.println("");




    }

}
