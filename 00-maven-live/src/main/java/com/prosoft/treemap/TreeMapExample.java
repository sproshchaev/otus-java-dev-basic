package com.prosoft.treemap;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapExample {

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
