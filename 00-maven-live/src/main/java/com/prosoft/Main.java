package com.prosoft;

import java.util.*;

/**
 * Live 2024-11-25
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Заполнение элементов
         */
        ArrayList<String> list = new ArrayList<>(); // 10
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

        list.clear(); // очистка всего листа

        System.out.println(list);

        /**
         * Методы класса ArrayList
         */
        // 1. boolean add(E e) - добавляем элементы в конец
        System.out.println(list.add("Apple"));
        list.add("Banana");
        list.add("Сherry");
        System.out.println(list);

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
         * Особенности работы с ArrayList
         */
        // Обращение к несуществующему объекту по индексу вызывает IndexOutOfBoundsException
        try {
            String item = list.get(100);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\"Исключение: \" + e");
        }

        // Попытка получить объект из пустого списка вызывает исключение, а не возвращает null
        ArrayList<String> emptyList = new ArrayList<>(); // пустой список
        try {
            String item = emptyList.remove(5);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\"Исключение: \" + e");
        }
        emptyList.add(null);
        System.out.println("Элемент на индексе 0: " + emptyList.get(0));

        // При удалении объекта из середины списка элементы сдвигаются влево
        list.add("Cherry");
        System.out.println("До удаления: " + list);
        list.remove(1);
        System.out.println("После удаления элемента 'Banana': " + list);

        // При добавлении элемента в начало/середину элементы сдвигаются вправо
        System.out.println("До добавления: " + list);
        list.add(0, "Apple");
        System.out.println("После добавления в начало: " + list);
        list.add(2, "Blueberry");
        System.out.println("После добавления в середину: " + list);

        // Нельзя добавлять элемент по индексу, “перепрыгивая” ячейки
        System.out.println("До добавления: " + list);
        try{
            list.add(10, "Banana");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Исключение: " + e);
        }

        /**
         * Связанный список LinkedList
         */
        // Создание
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("Первый");
        linkedList.add("Второй");
        linkedList.add("Третий");
        System.out.println("Начальный список: " + linkedList);

        // Добавление в начало
        linkedList.addFirst("Новый первый");
        System.out.println("После добавления в начало: " + linkedList);

        // Добавление в конец
        linkedList.addLast("Новый последний");
        System.out.println("После добавления в конец: " + linkedList);

        // Получение элемента по индексу
        System.out.println("Элемент с индексом 2: " + linkedList.get(2));

        // Получение первого и последнего элементов
        System.out.println("Первый элемент: " + linkedList.getFirst());
        System.out.println("Последний элемент: " + linkedList.getLast());

        // Удаление по индексу
        String item2 = linkedList.remove(2);
        System.out.println("Удаленный элемент " + item2);
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
        System.out.println("Содержит ли список 'Первый': " + linkedList.contains("Первый"));

        // Очистка списка
        linkedList.clear();
        System.out.println("После очистки список: " + linkedList);

        /**
         * Использование интерфейса List
         */
        //ArrayList<String> arrayList2 = new ArrayList<>();
        List<String> arrayList = new ArrayList<>();
        arrayList.add("A");
        arrayList.add("B");
        System.out.println("ArrayList: " + arrayList);

        // Создаем LinkedList
        List<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Элемент A");
        stringLinkedList.add("Элемент B");
        System.out.println("LinkedList: " + stringLinkedList);

        /**
         * Итератор + ConcurrentModificationException
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

        /**
         * Список автомобилей
         */
        ArrayList<Car> carList = new ArrayList<>();
        carList.add(new Car(1L, "BMW", "black"));
        carList.add(new Car(2L, "Audi", "blue"));
        carList.add(new Car(3L, "Volvo", "yellow"));

        // обход коллекции автомобилей через for и использование индексов (может быть исключение IndexOutOfBoundsException если будет ошибка в индексе)
        System.out.println("Cars:");
        for (int i = 0; i < carList.size(); i++) {
            System.out.println(carList.get(i).toString());
        }

        // обход коллекции автомобилей через for-each (безопасный)
        System.out.println("Cars:");
        for (Car car : carList) {
            System.out.println(car.toString());
        }

        // найти самый короткий бренд по числу букв
        Car carShortBrand = null;
        int shortBrandLength = Integer.MAX_VALUE;

        for (Car car : carList) {
            if (car.getBrand().length() < shortBrandLength) {
                shortBrandLength = car.getBrand().length();
                carShortBrand = car;
            }
        }

        if (carShortBrand != null) {
            System.out.println("Автомобиль с самым коротким полем brand: " + carShortBrand.getBrand());
        }

        /**
         * Пример проверки на null и !null
         */
        ArrayList<String> nullList = new ArrayList<>();

        nullList.add("Apple");
        nullList.add(null);
        nullList.add("Banana");
        nullList.add(null);
        nullList.add("Cherry");

        System.out.println("Список содержит null: " + nullList);

        for (String item : nullList) {
            if (item == null) {
                System.out.println("найден null");
            } else {
                System.out.println("это не null: " + item);
            }
        }

        /**
         * Счетчик элементов в коллекции
         */
        ArrayList<String> abcList = new ArrayList<>();

        abcList.add("AAA");
        abcList.add("BBB");
        abcList.add("AAA");
        abcList.add("CCC");
        abcList.add("AAA");

        int count = 0;

        for (String item : abcList) {
            if ("AAA".equals(item)) {
                count++;
            }
        }

        System.out.println("Последовательность 'AAA' найдена в коллекции " + count + " раз.");



    }
}

class Car {

    private Long id;
    private String brand;
    private String color;

    public Car(Long id, String brand, String color) {
        this.id = id;
        this.brand = brand;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}