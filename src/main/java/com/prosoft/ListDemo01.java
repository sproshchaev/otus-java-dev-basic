package com.prosoft;

import java.util.*;

public class ListDemo01 {

    public static void main(String[] args) {

        /**
         * (1) Изменение размера массива вручную с использованием метода
         * System.arraycopy(src, srcPos, dest, destPos, length),
         * где:
         *   src — исходный массив,
         *   srcPos — начальная позиция в исходном массиве,
         *   dest — целевой массив,
         *   destPos — начальная позиция в целевом массиве,
         *   length — количество копируемых элементов.
         */
        int[] originalArray = {1, 2, 3, 4, 5};
        System.out.println("Array before: " + Arrays.toString(originalArray));
        int newSize = 8;
        int[] newArray = new int[newSize];
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length - 1);
        originalArray = newArray;
        System.out.println("Array after: " + Arrays.toString(originalArray));

        /**
         * (2) Пример заполнения данных в ArrayList
         */
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add("A");
        }
        for (int i = 0; i < 5; i++) {
            list.add("B");
        }
        for (int i = 0; i < 8; i++) {
            list.add("C");
        }
        System.out.println(list);

        list.clear();

        /**
         * (3) Методы класса ArrayList
         */
        // 1. boolean add(E e) - добавляем элементы в конец
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        System.out.println("После добавления элементов: " + list);

        // 2. void add(int index, E e) - добавляем элемент на определенный индекс
        list.add(1, "Blueberry");
        System.out.println("После добавления элемента по индексу 1: " + list);

        // 3. E get(int index) - получаем элемент по индексу
        String fruit = list.get(2);
        System.out.println("Элемент на индексе 2: " + fruit);

        // 4. void set(int index, E e) - заменяем элемент на определенном индексе
        list.set(0, "Apricot");
        System.out.println("После замены элемента на индексе 0: " + list);

        // 5. E remove(int index) - удаляем элемент по индексу
        String removedElement = list.remove(3);
        System.out.println("Удален элемент '" + removedElement + "', список теперь: " + list);

        // 6. boolean remove(E e) - удаляем первый вхожденный элемент
        boolean isRemoved = list.remove("Blueberry");
        System.out.println("Удаление 'Blueberry': " + (isRemoved ? "успешно" : "не найдено") + ", список теперь: " + list);

        // 7. int size() - получаем текущий размер списка
        int size = list.size();
        System.out.println("Текущий размер списка: " + size);

        // 8. ensureCapacity(int cap) - гарантируем минимальную емкость
        list.ensureCapacity(20);
        System.out.println("Емкость увеличена до 20. (Видимой разницы нет, влияет на производительность)");

        // 9. void trimToSize() - уменьшаем емкость до текущего размера
        list.trimToSize();
        System.out.println("Емкость урезана до текущего размера. (Опять же, это внутренний процесс)");

        // 10. boolean contains(E e) - проверяем, содержится ли элемент
        boolean containsCherry = list.contains("Cherry");
        System.out.println("Содержится 'Cherry': " + containsCherry);

        /**
         * (4) Особенности работы с ArrayList
         * (4.1) Обращение к несуществующему объекту по индексу вызывает IndexOutOfBoundsException
         */
        System.out.println("!" + list);
        try {
            String item = list.get(100); // Индекса 100 не существует
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }

        /**
         * (4.2) Попытка получить объект из пустого списка вызывает исключение, а не возвращает null
         */
        ArrayList<String> emptyList = new ArrayList<>(); // Создание пустого списка
        try {
            String item = emptyList.get(5); // Список пуст, индекс 5 не существует
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }
        emptyList.add(null); // Чтобы получить `null`, его нужно положить в список
        System.out.println("Элемент на индексе 0: " + emptyList.get(0));

        /**
         * (4.3) При удалении объекта из середины списка элементы сдвигаются влево
         */
        list.add("Cherry");
        System.out.println("До удаления: " + list);
        list.remove(1); // Удаляем элемент на индексе 1
        System.out.println("После удаления элемента 'Banana': " + list);

        /**
         * (4.4) При добавлении элемента в начало/середину элементы сдвигаются вправо
         */
        System.out.println("До добавления: " + list);
        list.add(0, "Apple"); // Добавляем элемент в начало
        System.out.println("После добавления в начало: " + list);
        list.add(2, "Blueberry"); // Добавляем элемент в середину
        System.out.println("После добавления в середину: " + list);

        /**
         * (4.5) Нельзя добавлять элемент по индексу, “перепрыгивая” ячейки
         */
        System.out.println("До добавления: " + list);
        try {
            list.add(10, "Banana"); // Пытаемся добавить элемент на несуществующий индекс 10
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }

        /**
         * (5) Время выполнения методов ArrayList
         * (5.1) get() - доступ к элементу по индексу O(1) (постоянное время)
         * Формула: Адрес элемента = базовый адрес + (индекс × размер элемента),
         * где: Базовый адрес — это адрес первого элемента массива в памяти
         *      Индекс — это положение элемента в массиве, начиная с 0
         *      Размер элемента — это количество байт, необходимое для хранения одного элемента
         */
        list.clear();
        long startTime, endTime;
        String item;
        final long ONE_MILLION = 1_000_000; // число элементов и итераций
        list.add("Apple");

        // Измерение времени одного вызова ненадежно - лучше выполнить доступ 1 миллион раз и измерить среднее время
        startTime = System.nanoTime();
        for (int i = 0; i < ONE_MILLION; i++) {
            item = list.get(0);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время доступа get() к одному элементу: " + (endTime - startTime) / ONE_MILLION + " нс");

        for (int i = 0; i < ONE_MILLION; i++) { // + 1 млн элементов
            list.add("Apple " + i);
        }
        startTime = System.nanoTime();
        for (int i = 0; i < ONE_MILLION; i++) {
            item = list.get(500_000);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время доступа get() к элементу среди миллиона: " + (endTime - startTime) / ONE_MILLION + " нс");

        /**
         * (5.2) contains() - проверка наличия элемента в списке O(n) (линейное время)
         * Формула: Для поиска элемента в ArrayList метод contains() начинает с первого элемента и поочередно сравнивает
         * каждый элемент списка с искомым, пока не найдет совпадение или не дойдет до конца списка.
         * В худшем случае, если элемент не найден или находится в конце списка, необходимо проверить все n элементов.
         * Где:
         *      n — количество элементов в списке (ArrayList).
         */
        list.clear();
        list.add("Apple");
        final int ITERATIONS = 1_000; // число замеров
        // Измерение времени работы contains() для одного элемента
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            item = "Apple";
            list.contains(item);
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время вызова contains() для одного элемента: " + (endTime - startTime) / ITERATIONS + " нс");

        for (int i = 0; i < ONE_MILLION; i++) { // + 1 млн элементов
            list.add("Apple " + i);
        }
        // Измерение времени работы contains() для элемента среди миллиона
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            list.contains("Apple 500000");
        }
        endTime = System.nanoTime();
        System.out.println("Среднее время вызова contains() для элемента среди миллиона: " + (endTime - startTime) / ITERATIONS + " нс");

        /**
         * (6) Связанный список LinkedList
         */
        // Создаем LinkedList
        LinkedList<String> linkedList = new LinkedList<>();

        // Добавление элементов
        linkedList.add("Первый");
        linkedList.add("Второй");
        linkedList.add("Третий");
        System.out.println("Начальный список: " + linkedList);

        // Добавление в начало
        linkedList.addFirst("Новый Первый");
        System.out.println("После добавления в начало: " + linkedList);

        // Добавление в конец
        linkedList.addLast("Новый Последний");
        System.out.println("После добавления в конец: " + linkedList);

        // Получение элемента по индексу
        System.out.println("Элемент с индексом 2: " + linkedList.get(2));

        // Получение первого и последнего элементов
        System.out.println("Первый элемент: " + linkedList.getFirst());
        System.out.println("Последний элемент: " + linkedList.getLast());

        // Удаление по индексу
        linkedList.remove(2);
        System.out.println("После удаления элемента с индексом 2: " + linkedList);

        // Удаление первого элемента
        linkedList.removeFirst();
        System.out.println("После удаления первого элемента: " + linkedList);

        // Удаление последнего элемента
        linkedList.removeLast();
        System.out.println("После удаления последнего элемента: " + linkedList);

        // Замена элемента по индексу
        linkedList.set(1, "Замененный");
        System.out.println("После замены элемента с индексом 1: " + linkedList);

        // Проверка наличия элемента
        System.out.println("Содержит ли список 'Второй': " + linkedList.contains("Второй"));
        System.out.println("Содержит ли список 'Третий': " + linkedList.contains("Третий"));

        // Очистка списка
        linkedList.clear();
        System.out.println("После очистки список: " + linkedList);

        /**
         * (7) Использование интерфейса List
         */
        // Создаем ArrayList
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Элемент 1");
        arrayList.add("Элемент 2");
        System.out.println("ArrayList: " + arrayList);

        // Создаем LinkedList
        List<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Элемент A");
        stringLinkedList.add("Элемент B");
        System.out.println("LinkedList: " + stringLinkedList);

        /**
         * (8) Итератор + ConcurrentModificationException
         */
        List<String> listString = new ArrayList<>(Arrays.asList("A", "AAA", "AA", "AAAA", "A"));
        System.out.println("ArrayList: " + listString);
        for (String s : listString) {
            if (s.length() > 2) {
                // listString.remove(s); // При изменении коллекции в for-each возникает ошибка ConcurrentModificationException
            }
        }
        System.out.println("ArrayList after remove(): " + listString);

        // В отличие от цикла foreach, итератор позволяет изменять коллекцию во время ее обхода
        listString = new ArrayList<>(Arrays.asList("A", "AAA", "AA", "AAAA", "A"));
        System.out.println("ArrayList before: " + listString);
        Iterator<String> iterator = listString.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.length() > 2) {
                iterator.remove(); // Безопасное удаление
            }
        }
        System.out.println("ArrayList after iterator.remove(): " + listString);

        // Метод removeIf позволяет удалять элементы из коллекции на основе условия без необходимости явного использования итератора
        listString = new ArrayList<>(Arrays.asList("A", "AAA", "AA", "AAAA", "A"));
        System.out.println("ArrayList before: " + listString);
        listString.removeIf(s -> s.length() > 2);
        System.out.println("ArrayList after removeIf(): " + listString);
    }

}