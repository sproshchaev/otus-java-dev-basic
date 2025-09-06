package com.prosoft;

import static com.prosoft.Main.MyDefaultMethod;
import static com.prosoft.Main.MyProtectedMethod;

public class Other {
    public static void main(String[] args) {

        // Модификатор default доступен внутри класса и из других классов этого же пакета
        MyDefaultMethod();

        // Модификатор protected доступен для классов этого пакета
        MyProtectedMethod();
    }
}
