package ru.otus.example.work;

public class MyRunnable implements Runnable {
    // Флаг для контроля остановки потока
    private volatile boolean isRunning = true;

    @Override
    public void run() {
        while (isRunning) {
            // Выполнение задач
            System.out.println("Поток работает...");

            try {
                // Симуляция работы
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Сброс статуса прерывания
                System.out.println("Поток был прерван");
            }
        }
        System.out.println("Поток остановлен");
    }

    // Метод для безопасной остановки потока
    public void stop() {
        isRunning = false;
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        try {
            // Даем потоку поработать некоторое время
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Останавливаем поток
        myRunnable.stop();
    }
}
