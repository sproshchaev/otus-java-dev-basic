package ru.otus.example.seven;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 * <p>
 * #Демо7.5
 * 5) У Пула потоков есть метод .shutdownNow(), который используется для немедленного завершения пула потоков, прерывая
 * все его активные потоки исполнения.
 * Метод у всех текущих потоков пытается вызвать метод .interrupt().
 * Метод .shutdownNow() возвращает список задач, которые не были выполнены и были удалены из очереди пула.
 * Метод полезен в ситуациях, когда необходимо экстренно остановить пул потоков и предотвратить выполнение любых дополнительных задач.
 */
public class Main5 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 150; i++) {
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));
        }
        // Немедленно остановить пул потоков
        List<Runnable> uncompletedTasks = executorService.shutdownNow();
        System.out.println(uncompletedTasks); // список не выполненных задач
    }
}

