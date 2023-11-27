package ru.otus.javabasic.hw10;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneNumbers = new HashMap<>();

    public void add(String fio, String number) {
        if (containsPhoneNumber(number)) { // Проверка на дублирование номера телефона у разных Ф.И.О
            System.out.println("Такой номер уже существует");
        } else {
            if (phoneNumbers.containsKey(fio)) {
                phoneNumbers.get(fio).add(number);
            } else {
                List<String> list = new ArrayList<>();
                list.add(number);
                phoneNumbers.put(fio, list);
            }
        }
    }

    public List<String> find(String fio) {
        if (phoneNumbers.containsKey(fio)) {
            return phoneNumbers.get(fio);
        } else {
            System.out.println("Записи нет, добавьте номер телефона");
            return new ArrayList<String>(); //todo думаю, что нужно передавать пустой List
        }
    }

    public boolean containsPhoneNumber(String number) {
        boolean contains = false;
        Set<Map.Entry<String, List<String>>> set = phoneNumbers.entrySet();
        Iterator<Map.Entry<String, List<String>>> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().contains(number)) {
                return true;
            }
        }
        return contains;
    }
}