package ru.otus;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Use Java 11
 */
@SuppressWarnings("all")
public class InsideMap {

    private InsideMap() {
        throw new IllegalStateException("Utility class!");
    }

    public static void scan(Map<?, ?> map) {
        System.out.println("\nInsideMap.scan:\n---------------");
        Field table;
        try {
            table = map.getClass().getDeclaredField("table");
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("getDeclaredField(table) error!");
        }
        table.setAccessible(true);
        Object[] obj;
        try {
            obj = (Object[]) table.get(map);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Object table error!");
        }
        table.setAccessible(false);
        if (obj != null) {
            System.out.println("  CAPACITY (array size)=" + obj.length);
            for (int i = 0; i < obj.length; i++) {
                System.out.println("  bucket [" + i + "]: " + obj[i]);
            }
        } else {
            if (map.isEmpty()) {
                System.out.println("  Map is empty!");
            }
        }
        System.out.println("---------------\n");
    }

    public static int hash(Object key, int capacitySize) {
        return (key == null) ? 0 : (key.hashCode()) ^ (key.hashCode() >>> capacitySize);
    }

    public static String calcIndexTableMap(Map<?, ?> map, Object key) {
        Field capacityField;
        try {
            capacityField = map.getClass().getDeclaredField("DEFAULT_INITIAL_CAPACITY");
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("getDeclaredField(DEFAULT_INITIAL_CAPACITY) error!");
        }
        capacityField.setAccessible(true);
        int capacitySize;
        try {
            capacitySize = (Integer) capacityField.get(map);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException("Object capacity error!");
        }
        capacityField.setAccessible(false);
        return "Bucket index for key=" + key + ": " + (InsideMap.hash(key, capacitySize) & (capacitySize - 1));
    }

}