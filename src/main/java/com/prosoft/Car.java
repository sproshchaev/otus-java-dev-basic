package com.prosoft;

public class Car {

    // (1) Состояния или поля:
    private String brand; // марка
    private String color; // цвет
    private int number;   // номер

    // (2) Конструктор - главный метод класса
    public Car(String brand, String color, int number) {
        this.brand = brand;
        this.color = color;
        this.number = number;
    }

    // (3) Действия
    public void start(){
        System.out.println("Автомобиль поехал!");
    }

    public void stop() {
        System.out.println("Автомобиль остановился!");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
