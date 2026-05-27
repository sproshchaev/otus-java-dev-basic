package com.prosoft;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSerDemo {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        // .add()
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("a"); // дубль

        System.out.println(set); // [a, b, c]

        // .iterator()
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("value: " + iterator.next());
        }

        // for-each
        for(String value : set){
            System.out.println("value: " + value);
        }

        // остальные методы аналогично Map

    }

}
