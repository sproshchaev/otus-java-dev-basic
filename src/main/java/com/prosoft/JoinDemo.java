package com.prosoft;

public class JoinDemo {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("END");
    }

}
