package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 29 Основы многопоточности. Часть 2
 * #Демо7.7 Виды пулов потоков
 */
public class Main7 {

    public static void main(String[] args) {
        singleThreadExecutorDemo();
        fixedThreadPoolDemo();
        cachedThreadPoolDemo();
        scheduledThreadPoolDemo();
    }

    /**
     * 1) SingleThreadExecutor - пул из одного потока. Если мы ему даем 10 задач, то эти задачи будут выстроены в очередь
     * и выполняться последовательно. Это задачи, которые взаимно не пересекаются.
     */
    private static void singleThreadExecutorDemo() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }

    /**
     * 2) FixedThreadPool - пул потоков фиксированного размера. Число потоков передается в качестве аргумента при создании пула.
     * FixedThreadPool сначала инициализирует потоки, а затем передает в них задачи.
     */
    private static void fixedThreadPoolDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }

    /**
     * 3) CachedThreadPool - Работает как саморасширяющйся пул потоков. У него нет верхнего предела, поэтому если ему дать
     * задач больше, чем есть свободных ресурсов, то он использует все и система может упасть.
     */
    private static void cachedThreadPoolDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }

    /**
     * 4) ScheduledThreadPool - позволяет запускать задачу с задержкой по указанному времени
     */
    private static void scheduledThreadPoolDemo() {
        // Создание ScheduledThreadPool с фиксированным количеством потоков
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        for (int i = 0; i < 150; i++) {
            // Планирование выполнения задачи с задержкой в 1 секунду
            scheduledExecutorService.schedule(() -> {
                System.out.println(Thread.currentThread().getName());
            }, 1, TimeUnit.SECONDS);
        }

        // Ожидание завершения всех задач
        scheduledExecutorService.shutdown();
        try {
            // Ожидание завершения всех задач в течение 60 секунд. Если задачи не завершились в отведенное время, принудительно завершает работу пула.
            if (!scheduledExecutorService.awaitTermination(60, TimeUnit.SECONDS)) {
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduledExecutorService.shutdownNow();
        }
    }
}
