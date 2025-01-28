package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.HashMap;
import java.util.Map;

public class HashMapStructDemo {

    public static void main(String[] args) {

        // Создаем пустую HashMap с начальными значениями по умолчанию
        Map<String, Integer> defaultMap = new HashMap<>();
        Ljv.browse(defaultMap); // Capacity = 16 (начальная емкость по умолчанию)

        // Добавляем элементы
        defaultMap.put("One", 1);
        defaultMap.put("Two", 2);
        defaultMap.put("Three", 3);
        Ljv.browse(defaultMap); // Capacity = 16, size = 3

        // Создаем HashMap с пользовательской емкостью и load factor
        Map<String, Integer> customMap = new HashMap<>(20, 0.75f);
        Ljv.browse(customMap); // Capacity = 20, Load Factor = 0.75

        // Добавляем элементы, чтобы заполнить HashMap и инициировать увеличение емкости
        for (int i = 1; i <= 15; i++) {
            customMap.put("Key" + i, i);
        }
        Ljv.browse(customMap); // Capacity увеличивается после превышения threshold (15)

        // Создаем новую HashMap для демонстрации уникальности ключей
        Map<String, Integer> uniqueKeyMap = new HashMap<>(1); // Минимальный размер HashMap
        uniqueKeyMap.put("Key1", 10); // Добавляем первый ключ
        uniqueKeyMap.put("Key1", 100); // Перезаписываем значение для того же ключа
        Ljv.browse(uniqueKeyMap); // Проверяем, что "Key1" имеет только одно значение (100)

        // Создаем новую HashMap для работы с null-ключами и null-значениями
        Map<String, Integer> nullKeyMap = new HashMap<>(1); // Минимальный размер HashMap
        nullKeyMap.put(null, 999); // Добавляем ключ null
        nullKeyMap.put("NullValue", null); // Добавляем значение null
        Ljv.browse(nullKeyMap); // Проверяем, что HashMap поддерживает null-ключ и null-значения

        // Неупорядоченность элементов
        System.out.println("Элементы HashMap: ");
        customMap.forEach((key, value) -> System.out.println(key + " -> " + value));
    }
}
