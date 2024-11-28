package com.prosoft;

public class MyMapImpl implements MyMap {

    private int[] keys;
    private String[] values;

    public MyMapImpl(int[] keys, String[] values) {
        this.keys = keys;
        this.values = values;
    }

    @Override
    public String get(int key) {
        for (int i = 0; i < keys.length; i++) {
            if (key == keys[i]) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public void put(int key, String value) {
        for (int i = 0; i < keys.length; i++) {
            if (keys[i] == key) {
                values[i] = value;
                return;
            }
        }

        int[] newKeys = new int[keys.length + 1];
        String[] newValues = new String[values.length + 1];

        System.arraycopy(keys, 0, newKeys, 0, keys.length);
        System.arraycopy(values, 0, newValues, 0, values.length);

        newKeys[keys.length - 1] = key;
        newValues[newValues.length - 1] = value;

        keys = newKeys;
        values = newValues;
    }

    @Override
    public int size() {
        return keys.length;
    }
}
