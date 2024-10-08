package ru.otus.example.counter;

/**
 * Класс WaitNotifySimpleApp управляет потоками и синхронизацией изменений счетчика: 1
 * Один поток (вызывающий toOne()) увеличивает значение счётчика от 0 до 10, а другой поток (вызывающий toZero())
 * уменьшает его от 1 до 0.
 * Потоки синхронизированы, так что один поток не может изменить значение счётчика, если другой поток не завершил свою
 * операцию.
 * Это предотвращает возможные проблемы, такие как гонка данных.
 */
public class WaitNotifySimpleApp {

    private final Object mon = new Object(); // Монитор для синхронизации

    private Counter counter = new Counter();

    public static void main(String[] args) {
        WaitNotifySimpleApp waitNotifyApp = new WaitNotifySimpleApp();
        new Thread(() -> waitNotifyApp.toOne()).start();
        new Thread(() -> waitNotifyApp.toZero()).start();
    }

    /**
     * Метод toOne() синхронизируется на объекте mon.
     * В цикле (10 итераций) проверяет, что значение счётчика равно 0. Если оно не равно 0, поток вызывает mon.wait(),
     * чтобы ждать, пока не получит уведомление.
     * Если счётчик равен 0, увеличивает его значение с помощью метода inc(), а затем вызывает mon.notifyAll(),
     * чтобы уведомить другие потоки, что счётчик изменился.
     */
    public void toOne() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.getValue() != 0) {
                        mon.wait(); // Ожидание, пока значение не станет 0
                                    // Переход в "режим ожидания", освобождает монитор, пока другой поток не вызовет
                                    // метод notify()/notifyAll() на том же объекте
                    }
                    counter.inc();
                    mon.notifyAll(); // Уведомляем все ожидающие потоки о том, что значение изменилось
                                     // Разбудить потоки которые в "режиме ожидания"
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Метод toZero() синхронизируется на объекте mon.
     * В цикле (10 итераций) проверяет, что значение счётчика равно 1. Если оно не равно 1, поток вызывает mon.wait(),
     * чтобы ждать.
     * Если счётчик равен 1, уменьшает его значение с помощью метода dec(), а затем вызывает mon.notifyAll().
     */
    public void toZero() {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.getValue() != 1) {
                        mon.wait();
                    }
                    counter.dec();
                    mon.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Вложенный класс Counter
     */
    private class Counter {
        private int value;

        public void inc() {
            value++;
            System.out.println("Counter value after increment: " + value);
        }

        public void dec() {
            value--;
            System.out.println("Counter value after decrement: " + value);
        }

        public int getValue() {
            return value;
        }
    }

}
