package ru.otus.example.eight;

/**
 * 29 Основы многопоточности. Часть 2
 *
 * #Демо8.1
 * У нас есть класс Ящик, у которого создано два метода:
 * - fill() - заполняет ящик предметом
 * - clear() - очищает ящик, если предмет в нем есть
 * - isEmpty() - возвращает true если ящик пуст
 *
 * Создадим два потока:
 * - первый поток будет пытаться поместить в ящик предмет, если он пуст.
 * - второй поток будет пытаться очистить ящик, если он полон.
 *
 * У нас в выполнении методов в разных потоках будет присутствовать масса запросов на выполнение этих методов, которые
 * можно сократить. Если вызывать тогда, когда монитор освобожден. (см. Main2)
 */
public class Main {

    public static void main(String[] args) {

        Object monitor = new Object();
        Box box = new Box();

        /** Первый поток будет пытаться поместить в ящик предмет, если он пуст */
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread() + " checking the Box for .fill()");
                    if (box.isEmpty()) {
                        box.fill("Toy");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }).start();

        /** Второй поток будет пытаться очистить ящик, если он полон */
        new Thread(() -> {
            while (true) {
                synchronized (monitor) {
                    System.out.println(Thread.currentThread() + " checking the Box for .clear()");
                    if (!box.isEmpty()) {
                        box.clear();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
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
            System.out.println("In box: " + this.item + ".");
            this.item = item;
            System.out.println(item + " in the box.");
        }

        public void clear() {
            System.out.println("In box: " + this.item + ".");
            this.item = null;
            System.out.println("Box is empty!");
        }

        public boolean isEmpty() {
            return item == null;
        }
    }
}
