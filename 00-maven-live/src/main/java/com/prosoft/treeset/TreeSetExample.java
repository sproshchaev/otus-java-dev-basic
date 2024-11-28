package com.prosoft.treeset;

import java.util.*;

public class TreeSetExample {

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

class Car {
    private Integer id;
    private String brand;

    public Car(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(brand, car.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                '}';
    }
}
