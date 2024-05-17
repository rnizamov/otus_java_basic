package ru.otus.javabasic.hw22.utils.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayUtils {
    public static int[] getElementsAfterLastOne(int ...arr) {
        if (arr.length == 0) {
            return arr;
        }
        int lastIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                lastIndex = i;
            }
        }
        if (lastIndex == -1) {
            throw new ArrayException("В массиве не содержится элементов равных 1");
        }
        int destSize = arr.length - (lastIndex + 1);
        int[] dest= new int[destSize];
        for (int i = 0; i < dest.length; i++) {
            dest[i] = arr[lastIndex + 1 + i];
        }
        return dest;
    }

    public static boolean validateArrayContainsOnlyOneAndTwo(int ...arr) {
        List<Integer> list = List.of(1,2);
        Set<Integer> list2 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (!list.contains(arr[i])) {
                return false;
            } else {
                list2.add(arr[i]);
            }
        }
        return list.size() == list2.size();
    }
}