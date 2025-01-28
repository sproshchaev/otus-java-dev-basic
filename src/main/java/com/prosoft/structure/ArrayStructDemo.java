package com.prosoft.structure;

import com.prosoft.util.Ljv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayStructDemo {

    public static void main(String[] args) {

        int[] emptyArray = new int[5];
        Ljv.browse(emptyArray);

        int[] intArray = {10, 20, 30, 40, 50};
        Ljv.browse(intArray);
    }


}
