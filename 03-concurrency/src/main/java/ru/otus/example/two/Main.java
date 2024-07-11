package ru.otus.example.two;

/**
 * 29 Основы многопоточности. Часть 2
 * Пример работы с критической секцией на мониторе - экземпляре класса
 */
public class Main {

    private final Object monitor = new Object();

    /**
     * Пример 1 с критической секцией в методе
     * ---------------------------------------
     * У нас есть экземпляр класса main1 и мы у него будем вызывать в двух разных потоках один и тот же метод.
     * <p>
     * Если метод длинный и в нем можно выделить:
     * 1) части кода, которые могут потоками выполняться паралельно
     * 2) часть кода, которая должна потоками выполняться последовательно,
     * <p>
     * То мы для первого случая в методе не используем синхронизацию, а для второго случая используем synchronized
     * и указываем монитор, который у нас был определен в классе
     * <p>
     * Консоль:
     * Thread-0 Not syn: Start // <- потоки на старте выполняют код паралельно
     * .
     * Thread-1 Not syn: Start
     * .
     * .
     * .
     * .
     * .
     * Thread-0 Not syn: End
     * Thread-1 Not syn: End
     * Thread-0 Syn: Start // <- здесь потоки на критической секции отработали последовательно
     * .
     * .
     * .
     * Thread-0 Syn: End
     * Thread-1 Syn: Start
     * .
     * .
     * .
     * Thread-1 Syn: End
     */
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
