package com.prosoft;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsDemo {

    public static void readFile(String name) throws FileNotFoundException {
        FileInputStream f = new FileInputStream(name);
    }

}
