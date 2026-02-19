package ru.otus;

public class MyClass {

    private final Printer printer;

    public MyClass(Printer printer) {
        this.printer = printer;
    }

    public void doPrint(String string) {
        System.out.println("doPrint: " + string);
    }
}
