package ru.otus;

import java.net.Socket;

/**
 * Основы многопоточности. Часть 1 \\ ДЗ (19-02-2026)
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
        // myThread.run(); <- так мы не запускаем отдельный поток, а выполняем код в текущем main
        myThread.start(); // (3) вызов метода start

        Thread thread = new Thread(new MyTask()); // (3) создаем экз класса Thread и передаем экз класса реализующего Runnable
        thread.start(); // (4) вызов метода start

//        MyClass myClass = new MyClass();
//        myClass.doPrint("Hello, World!");

//        MyClass myClass = new MyClass() {
//            public void doPrint(String string) {
//                System.out.println("doPrint: " + string);
//            }
//        };
//        myClass.doPrint("Hello, World!");

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doPrint(String string) {
                System.out.println("doPrint: " + string + "!");
            }
        };
        myInterface.doPrint("Hello, World!!!!");

        MyClass myClass = new MyClass(new Printer() {
            @Override
            public void doPrint(String string) {
                System.out.println(string + "!");
            }
        });
        myClass.doPrint("Hello, World!");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                for (int i = 0; i < 5; i++) {
                    System.out.println("i=" + i);
                }

            }
        });
        thread2.start();

        // Свернутый в лямбду
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("i=" + i);
            }
        });
        thread3.start();

        thread.join();
        thread2.join();
        thread3.join();

        System.out.println("END");

    }

}