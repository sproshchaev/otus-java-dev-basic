package com.prosoft;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {

        Map<Integer, String> map = new HashMap<>();
        // HashMap<Integer, String> map1 = new HashMap<>();

        map.put(1, "One");
        map.put(2, "Two");

        // map.put(2, null);
        map.put(2, "Three");

        // map.put(null, null);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(" key=" + key + ", value=" + value);
        }

        System.out.println(map.get(1)); // O(1)
        System.out.println(map.get(100));

        System.out.println(map.containsKey(1));
        System.out.println(map.containsKey(100));

        // Как найти ключ по значению? O(n)
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (value.equals("Three")) {
                System.out.println("key=" + key + ", value=" + value);
                break;
            }
        }

        // Перебор всех ключей через .keySet() O(n)
        for (Integer key : map.keySet()) {
            System.out.println("key " + key);
        }

        // перебор ключей и значений через .keySet(), .get() O(n)
        for (Integer key : map.keySet()) {
            System.out.println("key " + key + " value " + map.get(key));
        }

        for (int i = 0; i < 13; i++) {
            map.put(i, String.valueOf(i));
        }

        // Пример Коллизий (хэшкод совпадает) - O(n)
        Map<String, String> map2 = new HashMap<>();
        String str = "AaAaAaAa";
        map2.put(str, "_Aa");

        String str2 = "AaAaAaBB";
        map2.put(str2, "_BB");


        for (String key : map2.keySet()) {
            System.out.println("key " + key + " value " + map2.get(key));
        }

        // метод удаления всех элементов .clear()
        map2.clear();
        System.out.println(map2 + "\n");

        // containsKey() возвращает true, если в Мапе есть данный ключ
        System.out.println(map.containsKey(1));

        // containsValue() возращает true если в мапе есть такое значение
        System.out.println(map);
        System.out.println(map.containsValue("0"));

        // Set<Map.Entry<K,V>>
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println("key=" + key + ", value=" + value);
        }

        // .get() возвращает или значение или null если ключа нет
        System.out.println(map.get(1));
        System.out.println(map.get(100));

        // .getOrDefault() возвращает значение если есть ключ или значение по умолчанию, если ключа в Мапе нет
        System.out.println(map.getOrDefault(1, "Yes!"));
        System.out.println(map.getOrDefault(100, "Yes!"));

        // isEmpty() - возвращает true если Мапа пуста
        System.out.println(map.isEmpty() + "\n");

        // keySet() формирует множество из ключей Мапы
        for (Integer key : map.keySet()) {
            System.out.println("key " + key);
        }

        // .put() добавляет пару "ключ - значение" в Мапу
        map.put(100, "100");
        System.out.println(map);

        // .putAll() добавляет одну мапу в другую
        Map<Integer, String> map3 = new HashMap<>();
        for (int i = 2; i < 5; i++) {
            map3.put(i, String.valueOf(i));
        }
        map.putAll(map3);
        System.out.println(map3);

        // метод .putIfAbsent() добавляет пару ключ-значение, если ключа нет
        map.putIfAbsent(1, "0!");
        map.putIfAbsent(1000, "0!");
        System.out.println(map);

        // remove() удаляет пару "K-V" из Мапы по ключу
        map.remove(1);
        System.out.println(map);

        // remove(k, v) удаляет элемент по ключу и значению
        System.out.println(map.remove(2, "2"));
        System.out.println(map);

        // values() возвращает коллекцию значений
        for (String value : map.values()) {
            System.out.println("value " + value);
        }

        // BrowseStructure.browse(new LJV(), map2);

    }

}
