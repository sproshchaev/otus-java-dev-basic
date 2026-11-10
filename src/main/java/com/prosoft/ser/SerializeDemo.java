package com.prosoft.ser;

import java.io.*;

public class SerializeDemo {

    public static void main(String[] args) {

        User user = new User("Иван", 30);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("user.ser"))) {
            out.writeObject(user);
            System.out.println("Объект сериализован в user.ser: " + user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("user.ser"))) {

            User user2 = (User) in.readObject();
            System.out.println("Объект восстановлен: " + user2);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}
