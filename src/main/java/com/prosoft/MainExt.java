package com.prosoft;

public class MainExt extends  Main {
    public void useProtected() {
        MyProtectedMethod(); // Разрешено внутри наследника
    }
}
