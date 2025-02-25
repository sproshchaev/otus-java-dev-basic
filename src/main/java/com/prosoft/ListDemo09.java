package com.prosoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListDemo09 {

    public static void main(String[] args) {

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
