package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 29 Основы многопоточности. Часть 2
 * #Демо7.8 Как использовать .join() в пуле потоков
 *
 * У Пула потоков есть метод .awaitTermination() - который обозначает то, что необходимо дождаться состояния Terminated.
 * В качестве аргумента передаются единицы: TimeUnit.DAYS, TimeUnit.HOURS, TimeUnit.MINUTES, TimeUnit.SECONDS и т.д.,
 * в течении которых мы будем ждать завершения всех потоков из Пула.
 */
public class Main8 {
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
