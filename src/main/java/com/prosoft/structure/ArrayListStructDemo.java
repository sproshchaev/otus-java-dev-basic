package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListStructDemo {

    public static void main(String[] args) {

        List<Integer> emptyList = new ArrayList<>();
        Ljv.browse(emptyList); // CAPACITY = 0

        emptyList.add(100);
        Ljv.browse(emptyList); // CAPACITY = 10 (значение по умолчанию)

        List<Long> longList = new ArrayList<>(20);
        Ljv.browse(longList); // задание CAPACITY = 20 через конструктор

        List<Integer> intList = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)); // тоже CAPACITY = 5
        intList.add(60); // увеличение CAPACITY = 5 x 1,5 = 7,5 (до 7)
        Ljv.browse(intList);
    }


}
