package ru.otus;

import java.util.HashMap;
import java.util.Map;

/**
 * Java collections framework: Map, Set demo (Java 11)
 * (Main - Edit Configurations - Java 11)
 *
 */
public class Main {

    private static final int SOME_NUMBER = 100;

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(i, i * SOME_NUMBER);
            System.out.println(InsideMap.calcIndexTableMap(map, i));
        }
        InsideMap.scan(map);

        /**
         * collision
         */
        Map<Car, Integer> mapCar = new HashMap<>();
        Car car1 = new Car(SOME_NUMBER, "bmw");
        mapCar.put(car1, 0);
        System.out.println(InsideMap.calcIndexTableMap(mapCar, car1));
        Car car2 = new Car(SOME_NUMBER, "bmw");
        mapCar.put(car2, 0);
        System.out.println(InsideMap.calcIndexTableMap(map, car2));
        InsideMap.scan(mapCar);

    }

}
