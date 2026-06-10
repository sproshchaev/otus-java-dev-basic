package com.prosoft;

public class StartVsRunDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("Работаю в потоке: "
                    + Thread.currentThread().getName());
        });
        // thread1.run(); // Работаю в потоке: main
        thread1.start(); // Работаю в потоке:  Thread-0
    }

}
