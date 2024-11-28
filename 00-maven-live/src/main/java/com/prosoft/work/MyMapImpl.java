package com.prosoft.work;

public class MyMapImpl implements  MyMap {
    private int[] keys;
    private String[] values;

    public MyMapImpl(int[] keys, String[] values) {
        this.keys = keys;
        this.values = values;
    }

    // Метод для получения значения по ключу
    public String get(int key) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                return values[i];
            }
        }
        return null; // Если ключ не найден
    }

    // Метод для добавления или обновления значения по ключу
    public void put(int key, String value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) { // Если ключ уже существует, обновляем значение
                values[i] = value;
                return;
            }
        }

        // Если ключ не найден, добавляем новую пару ключ-значение
        int[] newKeys = new int[keys.length + 1];
        String[] newValues = new String[values.length + 1];

        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        System.arraycopy(values, 0, newValues, 0, values.length);

        newKeys[newKeys.length - 1] = key;
        newValues[newValues.length - 1] = value;

        keys = newKeys;
        values = newValues;
    }

    // Метод для получения количества пар ключ-значение
    public int size() {
        return keys.length;
    }

}
