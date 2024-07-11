package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо7.2
 *
 * 2) Если мы создадим пул потоков и не произведем вызов .execute(), то этот Пул сразу завершит свою работу. Даже если мы не используем .shutdown()
 *
 * Консоль:
 * Process finished with exit code 0
 *
 * Если мы создаем пул потоков, но не создаем в нем задачи, то он завершает свою работу.
 */
public class Main2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }

}
