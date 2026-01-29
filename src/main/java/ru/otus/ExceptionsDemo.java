package ru.otus;

public class ExceptionsDemo {

    public static void main(String[] args) {

        // Перехват исключений через try-catch
        try {

            // ArrayIndexOutOfBoundsException
            int[] arr = {1, 2, 3};
            System.out.println("Элемент №5: " + arr[5]);

            // ArithmeticException
            int result = 10 / 0;

            int resultNext = result * 2;

        } catch (ArithmeticException e) {
            // Блок операторов которые выполняются в случае ArithmeticException
            System.out.println("На ноль делить нельзя!");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нельзя обращаться за границы диапазона индекса массива!");
            e.printStackTrace();
        }

        System.out.println("Приложение завершено (code 0)"); // Цель

    }

}
