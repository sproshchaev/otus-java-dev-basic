package ru.otus.example.eight;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо8.2
 * У нас есть класс Ящик, у которого создано два метода:
 * - fill() - заполняет ящик предметом
 * - clear() - очищает ящик, если предмет в нем есть
 * - isEmpty() - возвращает true если ящик пуст
 *
 * Создадим два потока:
 * - первый поток будет пытаться поместить в ящик предмет, если он пуст.
 * - второй поток будет пытаться очистить ящик, если он полон.
 *
 * Здесь мы добавим для Монитора вызов методов .wait() и .notifyAll() и это позволит сократить вызов пустых обращений
 * Мы начинаем с того, что Ящик пуст.
 */
public class Main2 {

    public static void main(String[] args) {
        Object monitor = new Object();
        Box box = new Box();

        /** Первый поток будет пытаться поместить в ящик предмет, если он пуст */
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println("Попытка положить предмет");
                    while (!box.isEmpty()) {
                        try {
                            System.out.println("Попытка положить предмет. Ожидаем ...");
                            monitor.wait(); // Засыпаем пока ящик полон
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    box.fill("Toy");
                    monitor.notifyAll(); // Уведомляем потоки, что ящик полон
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        /** Второй поток будет пытаться очистить ящик, если он полон */
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println("Попытка очистить предмет");
                    while (box.isEmpty()) {
                        try {
                            System.out.println("Попытка очистить предмет. Ожидаем ...");
                            monitor.wait(); // Засыпаем пока ящик пуст
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    box.clear();
                    monitor.notifyAll(); // Уведомляем потоки, что ящик пуст
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }

    /**
     * Класс ящик
     */
    private static class Box {
        private String item;
        public void fill(String item) {
            System.out.println("Наполнение: in box: " + this.item + ". " + item + " in the box.");
            this.item = item;
        }
        public void clear() {
            System.out.println("Очистка: in box " + this.item + ". Box is empty!");
            this.item = null;
        }
        public boolean isEmpty() {
            return item == null;
        }
    }
}
