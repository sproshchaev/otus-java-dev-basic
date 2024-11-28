package com.prosoft.work;

import java.util.*;

public class DemoTmp {

    public static void main(String[] args) {

        /**
         * Исходная задача
         */
        int[] digit = new int[] {1, 2, 3};
        String[] word = new String[] {"One", "Two", "Tree"};

        System.out.println(digit[0] + " перевод " + word[0]);
        System.out.println(digit[1] + " перевод " + word[1]);
        System.out.println(digit[2] + " перевод " + word[2] + "\n");

        /**
         * Кастомный Map
         */
        MyMap myMap = new MyMapImpl(digit, word);

        // перебор
        for (int i = 1; i <= myMap.size(); i++) {
            System.out.println(myMap.get(i));
        }

        // обновление значения
        myMap.put(1, "One new");

        // перебор 2
        for (int i = 1; i <= myMap.size(); i++) {
            System.out.println(myMap.get(i));
        }

        /**
         * Car, без переопределения hashCode и equals
         */
        System.out.println("Car: ");
        Car car1 = new Car(1, "bmw");
        Car car2 = new Car(2, "honda");

        System.out.println("  car1.hashCode()=" + car1.hashCode());
        System.out.println("  car2.hashCode()=" + car2.hashCode());
        System.out.println("  car1.equals(car2)=" + car1.equals(car2) + "\n");

        /**
         * Car, c переопределением hashCode и equals. Один hashCode, equals=true
         */
        System.out.println("Car: c переопределением hashCode и equals");
        Car car3 = new Car(1, "bmw");
        Car car4 = new Car(1, "bmw");
        System.out.println("  car3.hashCode()=" + car3.hashCode());
        System.out.println("  car4.hashCode()=" + car4.hashCode());
        System.out.println("  car3.equals(car4)=" + car3.equals(car4) + "\n");

        /**
         * Коллизии hashCode: разные объекты имеют одинаковый hashCode, но equals=false
         */
        String str1 = "AaAaAaAa";
        String str2 = "AaAaAaBB";
        System.out.println("str1.hashCode()=" + str1.hashCode()); // -540425984
        System.out.println("str2.hashCode()=" + str2.hashCode()); // -540425984
        System.out.println("str1.equals(str2)=" + str1.equals(str2) + "\n"); // false

        /**
         * HashMap: создание и заполнение
         */
        Map<Integer, String> map = new HashMap<>();
        // Map<int, String> map = new HashMap<>(); // unexpected type, required: reference

        map.put(1, "One");
        map.put(2, "Two");

        /**
         * HashMap: интерфейс Entry - методы getKey() и getValue()
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(" key=" + key + ", value=" + value);
        }
        System.out.println("");

        /**
         * HashMap: null может быть в ключе и значении
         */
        map.put(1, "One");  // Ключ 1, значение "One"
        // map.put(2);         Добавить ключ без значения мы не можем
        map.put(2, null);   // Можно поместить в значение null,
        map.put(2, "Two");  // а затем перезаписать значением
        // map.put(null, "Three");
        // map.put(null, null);

        /**
         * HashMap: получение значения get(), поиск по ключу и значению - containsKey(), containsValue()
         */
        System.out.println(map.get(1));               // One
        System.out.println(map.get(100));             // Если ключа нет, то получаем null
        System.out.println(map.containsKey(1));       // Как узнать  - есть ли ключ? true
        System.out.println(map.containsValue("Two") + "\n"); // Как узнать  - есть ли знач.?

        /**
         * HashMap: поиск ключа по значению через перебор всех пар через .entrySet()
         */
        for (Map.Entry<Integer, String> entry : map.entrySet()) { // переберем все for-each
            Integer key = entry.getKey();
            String value = entry.getValue();
            if (value.equals("Two")) {
                System.out.println(" key=" + key + ", value=" + value);
                break;
            }
        }
        System.out.println("");

        /**
         * HashMap: перебор всех ключей через .keySet()
         */
        for (Integer key : map.keySet()) {
            System.out.println("key " + key);
        }
        System.out.println("");

        /**
         * HashMap: перебор всех значений через .values()
         */
        for (String value : map.values()) {
            System.out.println("value " + value);
        }
        System.out.println("");

        /**
         * HashMap: перебор ключей и значений через .keySet(), .get()
         */
        for (Integer key : map.keySet()) {
            System.out.println("key " + key + " value " + map.get(key));
        }
        System.out.println("");

        /**
         * HashMap: метод удаления всех элементов .clear()
         */
        System.out.println(map); // {0=0, 1=1}
        map.clear();
        System.out.println(map + "\n"); // {}

        /**
         * HashMap: метод .getOrDefault() возвращает значение если есть ключ или значение по умолчанию, если ключа нет
         */
        map.put(1, "One");
        System.out.println(map); // {0=0, 1=1}
        System.out.println(map.getOrDefault(1, "Yes!")); // 1
        System.out.println(map.getOrDefault(100, "Yes!") + "\n"); // Yes!

        /**
         * HashMap: метод isEmpty() = true если структура пуста
         */
        System.out.println(map); // {0=0, 1=1}
        System.out.println(map.isEmpty() + "\n"); // false

        /**
         * HashMap: метод .putAll() добавляет одну структуру в другую
         */
        System.out.println(map);
        Map<Integer, String> map2 = new HashMap<>(); // 2-ая мапа
        for (int i = 2; i < 5; i++) {
            map2.put(i, String.valueOf(i));
        }
        System.out.println(map2);
        map.putAll(map2);                           // Добавляем map2 в map
        System.out.println(map + "\n");

        /**
         * HashMap: метод .putIfAbsent() добавляет пару ключ-значение, если ключа нет
         */
        System.out.println(map); // {1=One, 2=2, 3=3, 4=4}
        map.putIfAbsent(1, "0!");
        System.out.println(map); // {0=0, 1=1} ничего не изменилось, так как ключ есть
        map.putIfAbsent(100, "0!");
        System.out.println(map + "\n"); // {1=One, 2=2, 3=3, 4=4, 100=0!} добавилась пара с ключом 100

        /**
         * HashMap: метод .remove() удаляет пару ключ-значение из структуры по ключу
         */
        System.out.println(map); // {1=One, 2=2, 3=3, 4=4, 100=0!}
        map.remove(1);
        System.out.println(map + "\n"); // {2=2, 3=3, 4=4, 100=0!}

        /**
         * HashMap: метод .remove(k, v) удаляет элемент по ключу и значению
         */
        System.out.println(map);                  // {2=2, 3=3, 4=4, 100=0!}
        System.out.println(map.remove(0, "100")); // false - нет такой пары, не удалено
        System.out.println(map.remove(2, "2"));   // true, пара есть - удалено
        System.out.println(map + "\n");                  // {3=3, 4=4, 100=0!}

        /**
         * LinkedHashMap: создание экземпляра
         */
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
        Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>(16, .75f, true);
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");

        /**
         * LinkedHashMap: использование итератора для .entrySet() (рекомендуется использовать for)
         */
        Iterator<Map.Entry<Integer, String>> it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, String> entry = it.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println("");

        /**
         * LinkedHashMap: использование итератора для .keySet()
         */
        Iterator<Integer> itr2 = linkedHashMap.keySet().iterator();
        while(itr2.hasNext()) {
            System.out.println("key " + itr2.next());
        }
        System.out.println("");

        /**
         * LinkedHashMap: использование итератора для .values()
         */
        Iterator<String> itr3 = linkedHashMap.values().iterator();
        while (itr3.hasNext()) {
            System.out.println("value " + itr3.next());
        }
        System.out.println("");

        /**
         * LinkedHashMap: перебора элементов через for-each и .entrySet()
         */
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("key " + entry.getKey() + " = value " + entry.getValue());
        }
        System.out.println("");

        /**
         * HashSet: создание экземпляра и добавление элементов
         */
        Set<String> hashSet = new HashSet<String>();
        hashSet.add("1");
        hashSet.add("1");  // Если добавляем то, что уже есть то коллекция не изменяется
        hashSet.add("2");
        hashSet.add("3");
        System.out.println("hashSet: " + hashSet + "\n");

        /**
         * HashSet: размер структуры
         */
        System.out.println("size: " + hashSet.size() + "\n");

        /**
         * HashSet: for-each для перебора элементов
         */
        for (String str : hashSet) {
            System.out.println(str);
        }
        System.out.println("");

        /**
         * HashSet: метод remove() для удаления элемента
         */
        System.out.println("remove: " + hashSet.remove("3")); // true
        System.out.println("hashSet: " + hashSet + "\n");

        /**
         * HashSet: метод .contains() позволяет проверить наличие элемента
         */
        System.out.println("contains: " + hashSet.contains("2") + "\n"); // true

        /**
         * HashSet: метод .clear() удаляет все элементы
         */
        hashSet.clear();
        System.out.println("clear: " + hashSet + "\n");

        /**
         * HashSet: isEmpty() проверяет структуру на пустоту
         */
        System.out.println("isEmpty: " + hashSet.isEmpty());

















    }

}
