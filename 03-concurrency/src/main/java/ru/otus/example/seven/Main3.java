package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо7.3
 *
 * 3) У Пула потоков есть метод .isShutdown(), который возвращает true если был выполнен метод .shutdown()
 *
 */
public class Main3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.isShutdown()); // false
        executorService.shutdown();
        System.out.println(executorService.isShutdown()); // true
    }

}
