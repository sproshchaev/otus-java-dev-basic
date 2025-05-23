package ru.otus.java.basic.http.server;

public class Application {
    // Домашнее задание:
    // 1. Добавить логирование
    // 2. В CalculatorProcessor обработайте ситуации: параметры a, b не являются целыми числами (кинуть ошибку 400)
    // 3. В CreateItemProcessor нельзя передавать пустое название продукта или отрицательную цену (кинуть ошибку 400)
    // 4. Если в любом из обработчиков вылетело любое необработанное исключение, то сервер должен вернуть ответ 500

    public static void main(String[] args) {
         new HttpServer(8189).start();
    }
}
