package com.prosoft;

public class MyThreadDemo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        MyThreadDemo myThreadDemo = new MyThreadDemo();
        myThreadDemo.start();
    }

}
