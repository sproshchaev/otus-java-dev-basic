package com.prosoft;



public class EqualsHashCodeDemo {

    public static void main(String[] args) {
        Car car1 = new Car(1, "bmw");
        Car car2 = new Car(2, "honda");

        // hashCode: [-2 147 483 648 до 2 147 483 647]
        System.out.println("car1.hashCode(): " + car1.hashCode()); // 1791741888
        System.out.println("car2.hashCode(): " + car2.hashCode()); // 883049899
        System.out.println("car1.equals(car2): " + car1.equals(car2)); // false


        Car car3 = new Car(1, "bmw");
        Car car4 = new Car(1, "bmw");

        System.out.println("car3.hashCode(): " + car3.hashCode()); // 2093176254 -> 98668
        System.out.println("car4.hashCode(): " + car4.hashCode()); // 1854731462 -> 98668
        System.out.println("car3.equals(car4): " + car3.equals(car4)); // false -> true

        // Коллизии hashCode: [-2 147 483 648 до 2 147 483 647]
        String str1 = "AaAaAaAa"; // AaAaAaAa, AaAaAaBB, AaAaBBAa, AaAaBBBB, AaBBAaAa
        String str2 = "AaAaAaBB";
        System.out.println("str1.equals(str2): " + str1.equals(str2)); // false (!)
        System.out.println("str1.hashCode(): " + str1.hashCode()); // -540425984 - Коллизия
        System.out.println("str2.hashCode(): " + str2.hashCode()); // -540425984 - Коллизия

    }

}
