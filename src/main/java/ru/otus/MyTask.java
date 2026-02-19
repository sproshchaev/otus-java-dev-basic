package ru.otus;

/**
 * Второй вариант создания потоков через реализацию Runnable
 */
public class MyTask implements Runnable { // 1) имплементация Runnable

    @Override
    public void run() { // 2) переопределение метода run()
        for (int j = 0; j < 10; j++) {
            System.out.println("j=" + j);
        }
    }

}
