package com.prosoft;

public sealed class Animal permits Circle {

    public void run() {
        System.out.println("Побежали...");
    }

}
