package ru.otus.example;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 28 Основы многопоточности. Часть 2
 */
public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        List<Runnable> uncTask = executorService.shutdownNow();
        System.out.println(uncTask);
    }
}
