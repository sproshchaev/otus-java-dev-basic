package com.prosoft;

public class MyTaskDemo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyTaskDemo());
        thread1.start();
    }

}
