package com.prosoft;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        Comparator<Car> brandComparator = Comparator.comparing(Car::getBrand);

        TreeSet<Car> carTreeSet = new TreeSet<>(brandComparator);
        carTreeSet.add(new Car(1, "Toyota"));
        carTreeSet.add(new Car(2, "BMW"));
        carTreeSet.add(new Car(3, "Audi"));

        System.out.println("TreeSet (сортировка по бренду):");
        for (Car car : carTreeSet) {
            System.out.println(car);
        }
    }

}
