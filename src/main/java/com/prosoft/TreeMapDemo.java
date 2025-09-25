package com.prosoft;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        Comparator<Car> brandComparator = Comparator.comparing(Car::getBrand);

        TreeMap<Car, String> carTreeMap = new TreeMap<>(brandComparator);
        carTreeMap.put(new Car(1, "Toyota"), "Japan");
        carTreeMap.put(new Car(2, "BMW"), "Germany");
        carTreeMap.put(new Car(3, "Audi"), "Germany");

        System.out.println("\nTreeMap (ключи отсортированы по бренду):");
        for (Map.Entry<Car, String> entry : carTreeMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
