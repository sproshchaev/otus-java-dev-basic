package ru.otus.example.seven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 29 Основы многопоточности. Часть 2
 * <p>
 * #Демо7.1
 * 1) Давайте посмотрим, как создать 150 задач в 10 потоках с использованием интерфейса ExecutorService.
 * Интерфейс ExecutorService реализует класс Executors со статическим методом newFixedThreadPool(), который создает пул из числа потоков, которые передаются ему в качестве аргумента.
 * Пул потоков это некий менеджер потоков. Вы передаете свою задачу этому менеджеру, а он уже сам определяет в каком потоке из созданного пула ее необходимо запустить.
 * Если число задач для Пула потока больше, чем у него есть свободных потоков, то эти задачи выстраиваются в очередь и ожидают освобождение свободного потока в Пуле.
 * При таком подходе не тратится время для создания потока - как только мы вызвали .execute() то задачу тут же подхватывает свободный поток из Пула.
 * <p>
 * Консоль:
 * pool-1-thread-1
 * pool-1-thread-3
 * pool-1-thread-4
 * pool-1-thread-2
 * pool-1-thread-7
 * ...
 * Все эти задачи выполняются в пуле из 10 потоков. Эти 10 потоков не будут уничтожаться и не будут пересоздаваться.
 */
public class Main {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 150; i++) {

            // Мы в execute передаем new Runnable()
            executorService.execute(() -> System.out.println(Thread.currentThread().getName()));

        }

        /**
         * После завершения работы с пулом потоков вызываем метод .shutdown() иначе приложение не будет завершено.
         * После того как был вызван метод .shutdown() - пул потоков больше не сможет принимать задачи на выполнение.
         */
        executorService.shutdown();
    }

}
