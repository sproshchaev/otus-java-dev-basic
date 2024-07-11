package ru.otus.example.one;

/**
 * 29 Основы многопоточности. Часть 2
 */
public class Main {

    public static void main(String[] args) {
        Main main1 = new Main();
        Main main2 = new Main();

        /**
         * Пример 1:
         * ---------
         * Если два потока у одного и того же объекта main1 вызывать один и тот же синхронизированный метод .method1(),
         * то выполнение будет последовательным.
         * Консоль:
         * Thread-0 method1() started
         * Thread-0 method1() ended
         * Thread-1 method2() started
         * Thread-1 method2() ended
         *
         * Первый поток захватывает монитор main1 (экземпляр класса).
         * Монитором в данном случае выступает объект, у которого был вызван синхронизированный метод.
         */
        // new Thread(() -> main1.method1()).start();  // комментируем для примера 2
        // new Thread(() -> main1.method1()).start();  //                и примера 3, 4, 5

        /**
         * Пример 2:
         * ---------
         * Если два потока у одного и того же объекта main1 вызывают разные синхронизированные методы .method1() и .method2(),
         * то такое выполнение будет ТОЖЕ последовательным:
         */
         // new Thread(() -> main1.method1()).start();
         // new Thread(() -> main1.method2()).start();

        /**
         * Пример 3:
         * ---------
         * Если два потока у одного и того же объекта main1 вызывают разные синхронизированные методы .method2() и .method1(),
         * то такое выполнение будет ТОЖЕ последовательным.
         * Результат выполнения потоков всегда последовательный - какие бы мы методы не вызывали у синхронизированных
         * потоков: одинаковые или разные.
         *
         * Консоль:
         * Thread-0 method1() started
         * Thread-0 method1() ended
         * Thread-1 method2() started
         * Thread-1 method2() ended
         */
        //new Thread(() -> main1.method2()).start();
        //new Thread(() -> main1.method1()).start();

        /**
         * Пример 4:
         * ---------
         * Теперь давайте рассмотрим вариант, когда первый поток выполняет синхронизированный метод .method1(),
         * а второй - не синхронизированный метод .method3().
         *
         * Методы будут выполняться параллельно, так как блокировка на несинхронизированные методы не распространяется.
         * Консоль:
         * Thread-0 method1() started
         * Thread-1 method3() started
         * Thread-0 method1() ended
         * Thread-1 method3() ended
         */
        // new Thread(() -> main1.method1()).start();
        // new Thread(() -> main1.method3()).start();

        /**
         * Пример 5:
         * ---------
         * Вызов синхронизированных методов, но у разных объектов: main1 и main2.
         * Эти методы будут выполняться параллельно, так как Мониторы - разные.
         *
         * Консоль:
         * Thread-1 method1() started
         * Thread-0 method1() started
         * Thread-0 method1() ended
         * Thread-1 method1() ended
         */
         // new Thread(() -> main1.method1()).start();
         // new Thread(() -> main2.method1()).start();
    }

    /**
     * Синхронизированный метод 1
     */
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " method1() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method1() ended");
    }

    /**
     * Синхронизированный метод 2
     */
    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " method2() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method2() ended");
    }

    /**
     * Этот метод без синхронизации
     */
    public void method3() {
        System.out.println(Thread.currentThread().getName() + " method3() started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " method3() ended");
    }

}
