package com.prosoft;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            map.put(i, String.valueOf(i));
        }
        System.out.println(map.toString()); // {0=0, 1=1}

        // .containsKey()
        System.out.println("map.containsKey(1): " + map.containsKey(1)); // true

        // .containsValue()
        System.out.println("map.containsValue(\"1\"): " + map.containsValue("1")); // true

        // Перебор элементов entry = (key, value). entrySet(): (key1, value1), (key2, value2), ..., (keyN, valueN)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey(); // key1, key2, ... keyN
            String value = entry.getValue(); // value1, value2, ... valueN
            System.out.println("key=" + key + ", value=" + value);
        }

        // .get()
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(100)); // null

        // .getOrDefault()
        System.out.println("map.getOrDefault(1, \"Yes\"): " + map.getOrDefault(1, "Yes")); // 1
        System.out.println("map.getOrDefault(1, \"Yes\"): " + map.getOrDefault(100, "Yes")); // Yes

        // isEmpty()
        System.out.println(map.isEmpty()); // false

        // keySet()
        for (Integer key : map.keySet()) {
            System.out.println("key = " + key);
        }

        // .remove() удаление по ключу
        map.remove(1);
        System.out.println(map); // {0=0}

        // перебор значений в map
        for (String value : map.values()) {
            System.out.println("value: " + value);
        }




        // .clear
        map.clear();
        System.out.println(map.toString()); // {}

    }

}
