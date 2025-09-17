package com.prosoft.demo;

/**
 * Разные примеры исключений
 */
public class ExceptionsDemo {

        public static void main(String[] args) {
            System.out.println("=== Демонстрация различных типов исключений ===\n");

            // 1. ArithmeticException - арифметическая ошибка
            demonstrateArithmeticException();

            // 2. ArrayIndexOutOfBoundsException - выход индекса за пределы массива
            demonstrateArrayIndexOutOfBoundsException();

            // 3. ClassCastException - неверное приведение типов
            demonstrateClassCastException();

            // 4. IllegalArgumentException - недопустимый аргумент
            demonstrateIllegalArgumentException();

            // 5. IndexOutOfBoundsException - выход индекса за допустимые пределы
            demonstrateIndexOutOfBoundsException();

            // 6. NullPointerException - использование пустой ссылки
            demonstrateNullPointerException();

            // 7. NumberFormatException - неверное преобразование строки в число
            demonstrateNumberFormatException();
        }

        /**
         * ArithmeticException - деление на ноль
         */
        private static void demonstrateArithmeticException() {
            System.out.println("1. ArithmeticException:");
            try {
                int result = 10 / 0; // Попытка деления на ноль
                System.out.println("Результат: " + result);
            } catch (ArithmeticException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * ArrayIndexOutOfBoundsException - доступ к несуществующему элементу массива
         */
        private static void demonstrateArrayIndexOutOfBoundsException() {
            System.out.println("2. ArrayIndexOutOfBoundsException:");
            try {
                int[] arr = {1, 2, 3};
                System.out.println("Элемент массива с индексом 5: " + arr[5]); // Индекс вне границ
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * ClassCastException - неправильное приведение типов
         */
        private static void demonstrateClassCastException() {
            System.out.println("3. ClassCastException:");
            try {
                Object obj = "Hello World";
                // Попытка привести String к Integer (разные типы)
                Integer num = (Integer) obj;
                System.out.println("Преобразованное число: " + num);
            } catch (ClassCastException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * IllegalArgumentException - недопустимый аргумент метода
         */
        private static void demonstrateIllegalArgumentException() {
            System.out.println("4. IllegalArgumentException:");
            try {
                setAge(-5); // Передаем недопустимый возраст
            } catch (IllegalArgumentException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * Вспомогательный метод для демонстрации IllegalArgumentException
         */
        private static void setAge(int age) {
            if (age < 0) {
                // Бросаем исключение при недопустимом значении
                throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
            }
            System.out.println("   Возраст установлен: " + age);
        }

        /**
         * IndexOutOfBoundsException - общий случай выхода индекса за пределы
         */
        private static void demonstrateIndexOutOfBoundsException() {
            System.out.println("5. IndexOutOfBoundsException:");
            try {
                String str = "Java";
                // Попытка получить символ по несуществующему индексу
                char ch = str.charAt(10);
                System.out.println("Символ: " + ch);
            } catch (StringIndexOutOfBoundsException e) {
                // StringIndexOutOfBoundsException - подкласс IndexOutOfBoundsException
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * NullPointerException - использование null-ссылки
         */
        private static void demonstrateNullPointerException() {
            System.out.println("6. NullPointerException:");
            try {
                String str = null;
                // Попытка вызвать метод у null-объекта
                int length = str.length();
                System.out.println("Длина строки: " + length);
            } catch (NullPointerException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }

        /**
         * NumberFormatException - неверное преобразование строки в число
         */
        private static void demonstrateNumberFormatException() {
            System.out.println("7. NumberFormatException:");
            try {
                String notANumber = "abc123";
                // Попытка преобразовать нечисловую строку в целое число
                int number = Integer.parseInt(notANumber);
                System.out.println("Преобразованное число: " + number);
            } catch (NumberFormatException e) {
                System.out.println("   Поймано исключение: " + e.getMessage());
            }
            System.out.println();
        }
    }