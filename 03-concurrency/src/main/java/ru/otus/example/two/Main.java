package ru.otus.example.two;

/**
 * 29 Основы многопоточности. Часть 2
 */
public class Main {

    private final Object monitor = new Object();

    public static void main(String[] args) {
        Main main1 = new Main();
        new Thread(() -> main1.method()).start();
        new Thread(() -> main1.method()).start();
    }

    public void method() {
        try {
            // 1) Эту часть потоки выполняют параллельно
            System.out.println(Thread.currentThread().getName() + " Not syn: Start");
            for (int i = 0; i < 3; i++) {
                System.out.println(".");
                Thread.sleep(300);
            }
            System.out.println(Thread.currentThread().getName() + " Not syn: End");
            // 2) Здесь начинается критическая секция. Потоки выполняют последовательно
            synchronized (monitor) {
                System.out.println(Thread.currentThread().getName() + " Syn: Start");
                for (int i = 0; i < 3; i++) {
                    System.out.println(".");
                    Thread.sleep(300);
                }
                System.out.println(Thread.currentThread().getName() + " Syn: End");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
