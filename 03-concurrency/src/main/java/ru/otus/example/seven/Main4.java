package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо7.4
 *
 * 4) У Пула потоков есть метод .isTerminated().
 * Метод isTerminated() проверяет, завершился ли пул потоков, и все его потоки исполнения завершили свои задачи.
 *
 */
public class Main4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.isTerminated()); // false
        executorService.shutdown();
        System.out.println(executorService.isTerminated()); // true
    }

}
