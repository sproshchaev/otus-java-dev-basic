package com.prosoft;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {

        // Особенность Collection API в Java
        // ---------------------------------
        // Iterable -> Collection -> List -> ArrayList (индексы)
        //                                -> LinkedList

        // Map -> HashMap (пары K-V)
        //     -> ...

        Map<String, Integer> stringMap = new HashMap<>();
        stringMap.put("one", 1);


        Map<Integer, String> map = new HashMap<>();

        // .put() - добавить пару
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        map.clear(); // очистка значений
        System.out.println(map);

        for (int i = 1; i < 4; i++) {
            map.put(i, String.valueOf(i));
        }

        System.out.println(map); // {1=1, 2=2, 3=3}

        // поиск по ключу .containsKey()
        System.out.println(map.containsKey(2));  // true
        System.out.println(map.containsKey(22)); // false

        // поиск по значению .containsValue()
        System.out.println(map);
        System.out.println(map.containsValue("3")); // true
        System.out.println(map.containsValue(3)); // true

        // перебор элементов через for-each
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " : " + value);
        }

        // .get()
        System.out.println(map.get(1)); // 1
        System.out.println(map.get(11)); // null

        // .getOrDefault()
        System.out.println(map.getOrDefault(11, "11")); // 11 вместо null

        // .isEmpty()
        System.out.println(map.isEmpty()); // false - если мапа не пустая

        // .keySet() получаем множество ключей из Мапы
        for (Integer key : map.keySet()) {
            System.out.println("key : " + key); // key : 1, key : 2, key : 3
            // + .get(key) - получим значения
        }

        // .putIfAbsent() - добавляет пару если ключа нет
        map.putIfAbsent(1, "11");
        map.putIfAbsent(11, "11");
        System.out.println(map);

        // HashMap<Ключ-объект, Объект-значение>
        Map<Car, String> carStringMap = new HashMap<>();
        Car bmw = new Car(1L, "BMW");
        carStringMap.put(bmw, "х951рт72");
        System.out.println(carStringMap); // {Car{id=1, brand='BMW'} = х951рт72}

        // Телефонная книга
        Map<String, List<String>> phoneBook = new HashMap<>();
        phoneBook.put("Иванов И.И.", Arrays.asList("+792200881234", "+792200881235"));
        System.out.println(phoneBook);

        // .remove()
        map.remove(1);
        System.out.println(map); // {1=1, 2=2, 3=3, 11=11} -> {2=2, 3=3, 11=11}

        // .remove(к, v)

        // .values()
        for (String value : map.values()) {
            System.out.println("value: " + value); // value: 2, value: 3, value: 11
        }

    }

}
