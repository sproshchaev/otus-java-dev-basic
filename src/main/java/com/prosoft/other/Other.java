package com.prosoft.other;

// import static com.prosoft.Main.MyPrivateMethod;
// import static com.prosoft.Main.MyDefaultMethod;
// import static com.prosoft.Main.MyProtectedMethod;
import com.prosoft.Main;
import com.prosoft.MainExt;

import static com.prosoft.Main.MyPublicMethod;

public class Other {

    public static void main(String[] args) {

        // Метод с модификатором public можно вызвать из любого пакета
        MyPublicMethod();

        // Метод с модификатором private можно вызвать только внутри класса
        // MyPrivateMethod();

        // Модификатор default не доступен из других пакетов
        // MyDefaultMethod();

        // Модификатор protected не доступен для классов из другого пакета
        // MyProtectedMethod();

        // protected - доступен через наследование
        MainExt mainExt = new MainExt();
        mainExt.useProtected();
    }

}
