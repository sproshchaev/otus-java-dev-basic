package ru.otus.example.six;

/**
 * 29 Основы многопоточности. Часть 2
 * <p>
 * #Демо6 Как остановить поток, если он был запущен?
 *
 * В Java не рекомендуется использовать команду Stop для остановки потока.
 * Метод stop() устарел и может привести к непредсказуемому поведению, повреждению данных или даже к зависанию приложения.
 * Например, если в каком-то потоке у вас проводятся изменения в БД и вы вызовете завершение этого потока в том месте, где производится работа с данными - то эти данные могут быть утеряны.
 * Для остановки потока в Java следует использовать метод interrupt(). Метод interrupt() устанавливает флаг прерывания для потока, что сигнализирует потоку о необходимости завершить свою работу.
 * interrupt() сам поток сразу не остановит.
 * У потока есть внутри флаг isInterrupted(), который переходит в состояние true, когда мы вызываем метод interrupt().
 * И в нашем коде мы сами должны придумать схему корректной остановки работы потока.
 * Еще надо сказать про InterruptedException.
 * InterruptedException - это исключение, которое выбрасывается в потоке, когда он прерывается другим потоком.
 * Пока поток спит, то он не воспринимает команды. И если в тот момент, пока поток спит будет вызван interrupt(), то поток спит и не реагирует на него и перевести свой флаг isInterrupted() = True и поэтому возникает исключение InterruptedException.
 * Исключение InterruptedException выбрасывается в следующих случаях:
 * 1) Когда поток ожидает в методе, который может быть прерван, например, Thread.sleep() или Object.wait().
 * 2) Когда поток находится в блокирующем состоянии, например, при попытке приобрести блокировку или получить доступ к синхронизированному ресурсу.
 * Выбрасывание исключения InterruptedException позволяет потоку обработать прерывание и завершить свою работу должным образом.
 * Здесь Поток может либо обработать исключение InterruptedException и продолжить свою работу, либо повторно выбросить исключение, например throw new RuntimeException() чтобы его обработал вызывающий поток.
 *
 * Консоль:
 * methodOne() started
 * .
 * .
 * .
 * methodOne() ended
 * methodTwo() started
 * .
 * .
 * methodTwo() ended
 *
 */
public class Main {

    public static void main(String[] args) {

        methodOne(); // метод с .interrupt() - правильная остановка

        methodTwo(); // метод с .stop() - некорректная остановка

    }

    /**
     * Метод, использующий правильную обработку прерывания
     */
    public static void methodOne() {
        Thread threadOne = new Thread(() -> {
            System.out.println("methodOne() started");
            boolean interrupted = false;
            while (true) {
                // Мы останавливаем работу потока когда .isInterrupted() или мы обработали InterruptedException
                if (Thread.currentThread().isInterrupted() || interrupted) {
                    break;
                }
                System.out.println(".");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    //e.printStackTrace(); // <-  если раскоммент. то будет искл.
                    interrupted = true; // здесь обрабатываем InterruptedException в момент сна потока
                }
            }
        });
        threadOne.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadOne.interrupt(); // Корректное завершение работы потока
        System.out.println("methodOne() ended");
    }

    /**
     * Метод, использующий НЕ правильную обработку прерывания
     */
    public static void methodTwo() {
        Thread threadTwo = new Thread(() -> {
            System.out.println("methodTwo() started");
            // Запуск бесконечного цикла в потоке
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(".");
            }
        });
        threadTwo.start();
        try {
            Thread.sleep(3000);
            threadTwo.stop(); // Не корректное завершение. Помечен как устаревший. Показывает как ошибку компиляции, но запускается и вызывает UnsupportedOperationException
        } catch (InterruptedException | UnsupportedOperationException e) {
            e.printStackTrace();
        }
        System.out.println("methodTwo() ended");
    }

}
