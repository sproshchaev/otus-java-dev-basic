package ru.otus;

/**
 * Демонстрация создания потока и его запуск
 */
public class MyThread extends Thread { // (1) создать наследника от Thread

    @Override
    public void run() {
        // (2) Переопределить метод run: Здесь мы определяем то, что будет выполняться в потоке
        System.out.println(Thread.currentThread().getName()); // Thread-0
        for (int i = 0; i <= 5; i++) {
            System.out.println("i=" + i);
        }
    }

}
