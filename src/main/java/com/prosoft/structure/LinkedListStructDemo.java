package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.LinkedList;
import java.util.List;

public class LinkedListStructDemo {

    public static void main(String[] args) {

        List<Integer> emptyList = new LinkedList<>();
        Ljv.browse(emptyList); // LinkedList не имеет понятия о CAPACITY как ArrayList, здесь size = 0

        emptyList.add(100);
        Ljv.browse(emptyList); // Теперь size = 1, так как LinkedList увеличивает свой размер без явной емкости

        List<Long> longList = new LinkedList<>();
        longList.add(200L); // Добавляем элемент
        Ljv.browse(longList); // size = 1

        List<Integer> intList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            intList.add((i + 1) * 10);
        }
        Ljv.browse(intList); // size = 5

        intList.add(60); // Добавление элемента в LinkedList
        Ljv.browse(intList); // size = 6, в отличие от ArrayList, LinkedList не увеличивает емкость    }

    }

}
