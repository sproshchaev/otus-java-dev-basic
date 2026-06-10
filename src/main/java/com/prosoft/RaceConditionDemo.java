package com.prosoft;

public class RaceConditionDemo {

    static class Counter {
        int value = 0;
        public void inc() { value++; }
        public void dec() { value--; }
    }

    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.inc();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                counter.dec();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.value);
    }
}
