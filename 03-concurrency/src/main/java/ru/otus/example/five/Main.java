package ru.otus.example.five;

/**
 * 29 Основы многопоточности. Часть 2
 * <p>
 * #Демо5 Взаимные блокировки (Deadlock)
 * <p>
 * 1) Давайте посмотрим на практике как два потока могут произвести взаимную блокировку.
 * У нас есть два класса, в которых будет осуществляться взаимный захват общих мониторов.
 * <p>
 * Консоль:
 * Thread-1 Started
 * Thread-0 Started
 * Thread-1 Захватил Монитор 2
 * Thread-0 Захватил Монитор 1
 * <p>
 * И мы видим, что потоки перешли во взаимную блокировку и не могут выйти из этой ситуации. Приложение зависло.
 * <p>
 * 2) Пример разрешения взаимной блокировки
 * Для того, чтобы нам разрешить ситуацию с взаимной блокировкой потоков - нам необходимо изменить последовательность
 * синхронизации на мониторах в одном из классов. (комментарии отмечены '!!!')
 * <p>
 * Консоль:
 * Thread-0 Started
 * Thread-1 Started
 * Thread-0 Захватил Монитор 1
 * Thread-0 Захватил Монитор 1 и Монитор 2
 * Thread-0 Ended
 * Thread-1 Захватил Монитор 2
 * Thread-1 Захватил Монитор 2 и Монитор 1
 * Thread-1 Ended
 */
public class Main {
    private static final Object monitor1 = new Object();
    private static final Object monitor2 = new Object();

    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        ClassTwo classTwo = new ClassTwo();
        classOne.start();
        classTwo.start();
    }

    /**
     * Статический внутренний класс #1
     */
    private static class ClassOne extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Started");
            synchronized (monitor1) { // Захватывает Монитор1
                System.out.println(Thread.currentThread().getName() + " Захватил Монитор 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // И внутри захватывает Монитор2
                synchronized (monitor2) {
                    System.out.println(Thread.currentThread().getName() + " Захватил Монитор 1 и Монитор 2");
                }
            }
            System.out.println(Thread.currentThread().getName() + " Ended");
        }
    }

    /**
     * Статический внутренний класс #2
     */
    private static class ClassTwo extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Started");
            synchronized (monitor2) {  // Захватывает Монитор2                                                 // !!! для разрешения взаимной блокировки меняем monitor2 на monitor1
                System.out.println(Thread.currentThread().getName() + " Захватил Монитор 2");                  // !!! + " Захватил Монитор 1"
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // И внутри захвата Монитора2 еще захватывает Монитор1
                synchronized (monitor1) {                                                                      // !!! для разрешения взаимной блокировки меняем monitor1 на monitor2
                    System.out.println(Thread.currentThread().getName() + " Захватил Монитор 2 и Монитор 1");  // !!! + " Захватил Монитор 1 и Монитор 2"
                }
            }
            System.out.println(Thread.currentThread().getName() + " Ended");
        }
    }

}
