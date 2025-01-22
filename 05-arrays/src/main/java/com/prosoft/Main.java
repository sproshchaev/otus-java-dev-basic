package com.prosoft;

import java.util.Arrays;

/**
 * Java-Basic «Основы языка Java. Часть 2 \\ ДЗ» 21-01-2025
 */
public class Main {

    public static void main(String[] args) {

        // Перебор с фиксированным количеством итераций
        //for (int i = 0; i < 5; i++) {
        //    System.out.println("i=" + i);
        //}

        // Перебор чётных чисел
//        for (int i = 0; i <= 10; i += 2) {
//            System.out.println("i=" + i);
//        }

        // Перебор в обратном порядке
//        for (int i = 100; i >= 0; i -= 10) {
//            System.out.println("i=" + i);
//        }

        // long
        // float
//        for (float j = 0.1f; j < 5.0f; j = j + 0.2f) {
//            System.out.println("j=" + j);
//        }

        // Бесконечный цикл
//       for (;;) {
//           System.out.println("Hello World!");
//       }

        int[] arr1 = {1, 2, 3}; // new int [3];
        int[] arr2 = {4, 5, 6};
        // System.out.println("arr1[0] + arr2[0]=" + (arr1[0] + arr2[0]));
        // doSomethingWithArray(arr1);
        // doSomethingWithArray(new int[]{10, 20, 30});
        // doSomethingWithArrayVararg(2, 3, 4, 5, 6, 1);
        // doSomethingWithArrayVararg( 2, arr1);
        // compareArrays();
        // printArrays();
        // incrementEvenPositionElements();
        // zerifyElements();
        // hardCase1();
        // countElements();
        // fillArrayHalfByHalf();
        // sumArray();
        // fillArray();

        // Пример передачи параметра в метод по значению (примитивы)
        int i = 1;
        System.out.println("i before getByValue(i)=" + i); // 1
        getByValue(i); // значение аргумента увеличиваем на i = i + 1 внутри метода
        System.out.println("i after getByValue(i)=" + i); // 1 - значение не изменилось, так как для примитивов передается копия значения

        // Пример передачи параметра в метод по ссылке (объекты)
        System.out.println("arr1 before getByRef(arr1)=" + Arrays.toString(arr1)); // [1, 2, 3]
        getByRef(arr1); // обнуляем все значения элементов в массиве
        System.out.println("arr1 after getByRef(arr1)=" + Arrays.toString(arr1)); // [0, 0, 0] - значение изменилось, так как для объектов передается ссылка на объект

    }

    public static void doSomethingWithArray(int[] arr) {
        System.out.println("Длина массива =" + arr.length);
        System.out.println("Первый элемент=" + arr[0]); // Первый элемент
        System.out.println("Последний элемент=" + arr[arr.length - 1]);
    }

    public static void doSomethingWithArrayVararg(int x, int... arr) {
        System.out.println("Первый аргумент =" + x);
        System.out.println("Длина массива =" + arr.length);
        System.out.println("Первый элемент=" + arr[0]); // Первый элемент
        System.out.println("Последний элемент=" + arr[arr.length - 1]);
    }

    // Сверка двух массивов
    public static void compareArrays() {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
        int[] arr2 = {1, 1, 2, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int counter = 0;
        for (int i = 0; i < Integer.min(arr.length, arr2.length); i++) {
            //System.out.println("i=" + i);
            if (arr[i] == arr2[i]) {
                counter++;
            }
        }
        System.out.println("arr=" + Arrays.toString(arr)); // через Arrays.toString()
        System.out.println("arr2=" + Arrays.toString(arr2)); // через Arrays.toString()
        System.out.println("counter=" + counter);
    }

    // Как вывести в консоль массивы
    public static void printArrays() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 2, 3, 5, 6, 8};
        // Вывод через цикл
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
        // через Arrays.toString()
        System.out.println("arr=" + Arrays.toString(arr));
    }

    // Как увеличить элементы на четных позициях на 1
    public static void incrementEvenPositionElements() {
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            // проверка на четность
            if (arr[i] % 2 == 0) {
                arr[i] = arr[i] + 1; // сокращенный вариант arr[i]++;
            }
        }
        System.out.println("arr=" + Arrays.toString(arr));
    }

    // Как занулить определенные элементы массива
    private static void zerifyElements() {
        int[] arr = {1, 2, 3, 4, 4, 5, 5};
        // Зануление по значению 4 и 5
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4 || arr[i] == 5) {
                arr[i] = 0;
            }
        }
        System.out.println("arr=" + Arrays.toString(arr));
    }

    // Определить количество ячеек, в которых следующим элементом идет число на 1 больше
    private static void hardCase1() {
        int[] arr = {1, 2, 4, 4, 4, 5, 6, 2, 3, 5, 6, 8};
        int counter = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1] - 1) {
                counter++;
            }
        }
        System.out.println("arr=" + Arrays.toString(arr));
        System.out.println("counter=" + counter);
    }

    // Количество четных чисел и положительных
    private static void countElements() {
        int[] arr = {1, -1, 1, 1, -1, 1, 1, 2, 2, 2, 2, 2};
        int evenNumbersCount = 0;
        int positiveNumbersCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenNumbersCount++;
            }
            if (arr[i] >= 0) {
                positiveNumbersCount++;
            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("evenNumbersCount=" + evenNumbersCount);
        System.out.println("positiveNumbersCount=" + positiveNumbersCount);
    }

    // Заполнение половины массива (левая и правая)
    private static void fillArrayHalfByHalf() {
        int[] arr = new int[10];
        // слева
        for (int i = 0; i < arr.length / 2; i++) {
            arr[i] = 1;
        }
        // справа
        for (int i = arr.length / 2; i < arr.length; i++) {
            arr[i] = 2;
        }
        System.out.println("arr=" + Arrays.toString(arr));
    }

    // Сумма элементов массива
    private static void sumArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("sum=" + sum);
    }

    // Заполнение массива определенным значением
    private static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100;
        }
        System.out.println("arr=" + Arrays.toString(arr));
    }

    // Получение аргумента по ссылке (примитивы)
    public static void getByValue(int value) {
        // изменяем значение value
        value++;
        System.out.println("getByValue: i=" + value);
    }

    // Получение аргумента по ссылке (объекты)
    public static void getByRef(int[] array) {
        // Обнуляем значения массива
        Arrays.fill(array, 0);
        System.out.println("getByRef: arr1=" + Arrays.toString(array));
    }

}