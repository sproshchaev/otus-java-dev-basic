package ru.otus.example.work;

import java.util.concurrent.*;

/**
 * Пример использования метода .awaitTermination() (аналог ".join() в пуле потоков")
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
        // аналог .join
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished");
    }
}
