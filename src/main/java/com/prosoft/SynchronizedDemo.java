package com.prosoft;

public class SynchronizedDemo {

    static class Counter {
        int value;
        public synchronized void inc() { value++; }
        public synchronized void dec() { value--; }
    }

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
                counter.inc();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 100000; i++) {
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
