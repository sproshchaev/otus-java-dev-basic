package ru.otus.example.seven;

import java.util.concurrent.*;

/**
 * 29 Основы многопоточности. Часть 2
 * #Демо7.6
 * 6) Метод .submit() - получение информации о том как выполняется задача в пуле потоков.
 */
public class Main6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        submitDemo();
        submitDemo2();
    }

    /**
     * 6.1) В метод .execute() у нас передается new Runnable(). Это то, что когда-то должно выполнится.
     * Если нужно получить результат выполнения, то можно использовать метод .submit().
     * Мы получаем ссылку на объект Future, а это статус выполнения задачи в потоке:
     * cancel() - отмена задачи,
     * get() - результат выполнения он блокирующий и мы будем ждать,
     * isCancelled() - задача отменена?
     * isDone() - задача выполнена?
     */
    private static void submitDemo() throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Starting thread");
        Future future = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
                System.out.println(".");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        // пробраcываем Exception
        System.out.println(future.get()); // null (так как .run() возвращает void)
        System.out.println("Finished thread");
        executorService.shutdownNow();
    }

    /**
     * 6.2) Если мы хотим получить через .submit() результат, то вместо new Runnable() мы в него должны передать new Callable()
     */
    private static void submitDemo2() throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Starting thread");

        // Так же можно писать через лямбду, но добавить return
        // Future future = executorService.submit(() -> { ... return ...}
        Future future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return "Hello World!";
            }
        });

        /**
         * Метод future.get() является блокирующим - наше приложение будет висеть на этом месте пока мы не получим ответ
         */
        System.out.println(future.get()); // Hello World!
        System.out.println("Finished thread");
        executorService.shutdownNow();
    }


}
