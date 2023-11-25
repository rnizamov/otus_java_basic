package ru.otus.javabasic.hw10;
import java.util.*;

public class PhoneBook {
    private static Map<Long, String> phoneNumbers = new HashMap<>();

    public static void add(long number, String fio) {
        phoneNumbers.put(number, fio);
    }

    public static Set<Long> find(String fio) {
        Set<Long> set = new TreeSet<>();
        for (Map.Entry<Long, String> entry : phoneNumbers.entrySet()) {
            if (entry.getValue().equals(fio)) {
               set.add(entry.getKey());
            }
        }
        return set;
    }

    public static boolean containsPhoneNumber(long number) {
        boolean contains = false;
        if (phoneNumbers.size() > 0) {
            contains = phoneNumbers.containsKey(number);
        }
        return contains;
    }
}