package com.prosoft;

import java.util.ArrayList;

public class ListDemo03 {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        // add
        list.add("Apple");
        list.add("Apple2");
        list.add("Apple3");
        System.out.println(list);

        // add(int index, E e)
        list.add(1, "Blueberry");
        System.out.println(list);

        // E get(int index)
        String fruit = list.get(2);
        System.out.println("Элемент на индексе 2: " + fruit);

        // void set(int index, E e)
        list.set(0, "Apricot");
        System.out.println("После замены элемента на индексе 0: " + list);

        // E remove(int index)
        String removedElement = list.remove(3);
        System.out.println("Удален элемент " + removedElement);
        System.out.println(list);

        // boolean remove(E e)
        boolean isRemoved = list.remove("Blueberry");
        System.out.println("Удаление Blueberry" + (isRemoved ? " успешно" : " не найдено"));
        System.out.println(list);

        // int size()
        int size = list.size();
        System.out.println("Текущий размер списка: " + size);

        // ensureCapacity(int cap) - минимальная емкость (по умолчанию 10) (***)
        list.ensureCapacity(20);

        // задание капасити через конструктор класса
        ArrayList<String> list2 = new ArrayList<>(20);

        // void trimToSize() - уменьшаем емкость (capacity) до текущего размера (***)
        list.trimToSize();

        // boolean contains(E e) - проверка содержится ли этот элемент в списке
        boolean containsCherry = list.contains("Cherry");
        System.out.println("Содержится Cherry: " + containsCherry);

        boolean containsApple2 = list.contains("Apple2");
        System.out.println("Содержится Apple2: " + containsApple2);

    }

}
