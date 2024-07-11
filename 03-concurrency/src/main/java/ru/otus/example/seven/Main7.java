package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 * #Демо7.7 Виды пулов потоков
 */
public class Main7 {

    public static void main(String[] args) {
        singleThreadExecutorDemo();
        fixedThreadPoolDemo();
        cachedThreadPoolDemo();
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
     * задач больше, чем есть свободных ресурсов, то он использует все и система може упасть.
     */
    private static void cachedThreadPoolDemo() {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        executorService.shutdown();
    }

    /**
     *   4) ScheduledThreadPool - позволяет запускать задачу по определенному расписанию - раз в час, через 20 секунд и тп
     *   ExecutorService executorService = Executors.newScheduledThreadPool(...);
     *   где ... задается порядок запуска.
     */

}
