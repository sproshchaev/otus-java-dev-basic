package com.prosoft;

public class LambdaThreadDemo {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        });
        thread1.start();
    }

}
