package com.prosoft;

public class EqualsHashCodeDemo {

    public static void main(String[] args) {
        System.out.println("Car:");
        Car car1 = new Car(1, "bmw");
        Car car2 = new Car(2, "honda");

        System.out.println("car1=" + car1.hashCode());
        System.out.println("car2=" + car2.hashCode());
        System.out.println("car1.equals(car2)=" + car1.equals(car2));

        Car car3 = new Car(1, "bmw");
        Car car4 = new Car(1, "bmw");
        System.out.println("car3=" + car3.hashCode());
        System.out.println("car4=" + car4.hashCode());
        System.out.println("car3.equals(car4)=" + car3.equals(car4));

        // Коллизии
        String str1 = "AaAaAaAa";
        String str2 = "AaAaAaBB";
        System.out.println("str1.hashCode()=" + str1.hashCode());
        System.out.println("str2.hashCode()=" + str2.hashCode());
        System.out.println("str1.equals(str2)=" + str1.equals(str2) + "\n");
    }

}
