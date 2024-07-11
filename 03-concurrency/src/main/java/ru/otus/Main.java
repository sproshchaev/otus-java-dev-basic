package ru.otus;

public class Main {
    public static void main(String[] args) {
        Main main1 = new Main();
        Main main2 = new Main();
        new Thread(() -> main1.method1()).start();
        new Thread(() -> main1.method1()).start();
    }
    // Синхронизированный метод 1
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " method1() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method1() ended");
    }
    // Синхронизированный метод 2
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " method2() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method2() ended");
    }
    // Этот метод без синхронизации
    public void method3() {
        System.out.println(Thread.currentThread().getName() + " method3() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method3() ended");
    }
}
