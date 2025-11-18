package ru.otus;

/**
 * Otus: Практикум по работе с исключениями
 */
public class Main {

    public static void main(String[] args) {

        // Process finished with exit ...
        //  - code 0 - нормальное завершение программы
        //  - code 1 - завершение при возникновении Исключения

        String input = "abc"; // "100", "100.05", ...
        int[] arr = {1, 2, 3};
        int a = 100;

        // Выбрасывание исключения в программе: throw исключение;

        // конструкция try-catch
        try {
            int number = Integer.parseInt(input); // "100" -> 100 потенциально NumberFormatException
            System.out.println(arr[10]);          // потенциально ArrayIndexOutOfBoundsExceptions
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
            System.out.println("Была ошибка преобразования формата или ошибка выхода за пределы массива!");
        }

        // Предугадываем ситуацию и проверяем переменную b
        // if (b != 0) {
        //    System.out.println("a / b = " + (a / b)); // ArithmeticException "/ by zero"
        //} else {
        //    System.out.println("Возможна потенциальная ошибка деления на ноль!");
        //}

    }

}