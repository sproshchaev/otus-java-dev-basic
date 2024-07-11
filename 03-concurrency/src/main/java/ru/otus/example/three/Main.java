package ru.otus.example.three;

/**
 * 29 Основы многопоточности. Часть 2
 * Пример работы на статическом мониторе (монитор это сам класс)
 */
public class Main {

    public static void main(String[] args) {
        Main main1 = new Main();

        /**
         * Пример 1 со статическими методами. Монитор - сам класс
         * ------------------------------------------------------
         * Работа со статическими методами в потоках.
         * Есть класс в котором написаны два статических метода и мы вызываем в разных потоках сначала classMethod1(),
         * затем classMethod2()
         * Потоки выполняются последовательно - монитором выступает сам класс. При этом если мы во втором потоке вызываем
         * classMethod2, то последовательность потоков не изменяется.
         * Консоль:
         * Thread-0 Syn static method1: Start
         * .
         * .
         * .
         * Thread-0 Syn static method1: End
         * Thread-1 Syn static method1: Start
         * .
         * .
         * .
         * Thread-1 Syn static method1: End
         */
        new Thread(() -> classMethod1()).start();    // комментируем для Примера 3
        new Thread(() -> classMethod1()).start();    // эти строки

        /**
         * Пример 3 Вызов статических методов и метода экземпляра класса
         * -------------------------------------------------------------
         * Работа статических методов и метода экземпляра класса. Все методы будем запускать в разных потоках.
         * Если метод синхронизирован и статический, то монитором выступает сам Класс.
         * Если метод синхронизирован, то монитором является экземпляр класса (this)
         * В данном случае у нас мониторы разные и статические методы выполняются последовательно, а метод экземпляра
         * класса - параллельно со статическими.
         * Консоль:
         * Thread-2 Syn objMethod1() started
         * Thread-0 Syn static method1: Start
         * .
         * .
         * .
         * Thread-0 Syn static method1: End
         * Thread-1 Syn static method2: Start
         * .
         * Thread-2 Syn objMethod1() ended
         * .
         * .
         * Thread-1 Syn static method2: End
         */
         // new Thread(() -> classMethod1()).start();
         // new Thread(() -> classMethod2()).start();
         // new Thread(() -> main1.objMethod1()).start();
    }

    /**
     * Статический синхронизированный метод класса #1
     */
    public static synchronized void classMethod1() {
        System.out.println(Thread.currentThread().getName() + " Syn static method1: Start");
        for (int i = 0; i < 3; i++) {
            System.out.println(".");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Syn static method1: End");
    }

    /**
     * 2) Статический синхронизированный метод класса #2
     */
    public static synchronized void classMethod2() {
        System.out.println(Thread.currentThread().getName() + " Syn static method2: Start");
        for (int i = 0; i < 3; i++) {
            System.out.println(".");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " Syn static method2: End");
    }

    /**
     * Синхронизированный метод класса (его вызываем на объекте)
     */
    public synchronized void objMethod1() {
        System.out.println(Thread.currentThread().getName() + " Syn objMethod1() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " Syn objMethod1() ended");
    }

}
