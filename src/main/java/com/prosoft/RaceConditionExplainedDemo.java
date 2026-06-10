package com.prosoft;

public class RaceConditionExplainedDemo {

    static class Counter {
        int value;
        public void incSlow() {
            int temp = value; // get - чтение значения
            temp = temp + 1;  // ++
            value = temp;     // set
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.incSlow();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.incSlow();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Ожидаем 200 000, получаем: " + counter.value);

    }

}
