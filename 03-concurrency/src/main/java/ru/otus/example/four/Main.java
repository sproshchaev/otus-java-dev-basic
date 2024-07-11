package ru.otus.example.four;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо4
 *
 * 1) Мы создадим класс, который будет работать с двумя полями. В конструкторе зададим начальные значения и через методы
 * inc() и dec() будем увеличивать и уменьшать значения полей. Синхронизировать на методе не будем - создадим
 * критические секции в самом методе и объявим два монитора на объектах Object
 *
 * Консоль:
 * Thread-0 start
 * Thread-1 start
 * Thread-0 end
 * Thread-1 end
 * Main{c1=1000, c2=1000}
 *
 * 2) Теперь если мы уберем критические секции из методов, то код сразу будет работать не правильно
 * public void inc1() {
 *   // synchronized (mon1) {
 *         c1++;
 *   // }
 * }
 * Консоль:
 * Thread-1 start
 * Thread-0 start
 * Thread-1 end
 * Thread-0 end
 * Main{c1=74696, c2=1000} // Мы видим, что значение счетчика не 1000 как мы ожидаем
 */
public class Main {

    private int c1 = 0;
    private int c2 = 0;

    private final Object mon1 = new Object();
    private final Object mon2 = new Object();

    public static void main(String[] args) throws InterruptedException {
        Main main = new Main(1000, 1000);

        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 0; i < 1000000; i++) { // 1 млн раз +
                main.inc1();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            for (int i = 0; i < 1000000; i++) { // 1 млн раз -
                main.dec1();
            }
            System.out.println(Thread.currentThread().getName() + " end");
        });
        thread1.start();  // Запускаем потоки
        thread2.start();
        thread1.join();   // Вызываем метод join, чтобы основной поток
        thread2.join();   // дождался завершения запущенных потоков
        System.out.println(main);
    }
    public Main(int c1, int c2) {  // Конструктор для инициализации полей
        this.c1 = c1;
        this.c2 = c2;
    }
    public void inc1() { // метод inc1, увеличивающий значение поля c1
        synchronized (mon1) {  // используется монитор mon1
            c1++;
        }
    }
    public void dec1() { // метод dec1, уменьшающий значение поля c1
        synchronized (mon1) {  // монитор mon1
            c1--;
        }
    }
    public void inc2() { // метод inc2, увеличивающий значение поля c2
        synchronized (mon2) {  // синхронизация на мониторе mon2
            c2++;
        }
    }
    public void dec2() { // метод dec2, уменьшающий значение поля c2
        synchronized (mon2) {  // синхронизация на мониторе mon2
            c2--;
        }
    }
    @Override
    public String toString() {  // переопределим метод toString
        return "Main{" + "c1=" + c1 + ", c2=" + c2 + "}";
    }
}
