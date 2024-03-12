package ru.otus.javabasic.hw9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork9 {
    public static List getRangeList(int min, int max) {
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return list;
    }

    public static int getSumElementsGreaterThan5(List<Integer> list) {
        return list.stream().filter(e -> e > 5).reduce(0, Integer::sum);
    }

    public static void fillList(List<Integer> list, int el) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, el);
        }
    }

    public static void increasingList(List<Integer> list, int el) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + el);
        }
    }

    public static List<String> getEmployeeNames(List<Employee> employees) {
        return employees.stream().map(e -> e.getName()).collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeWithAgeGreaterOrEqualsThan(List<Employee> list, int age) {
        return list.stream().filter(e -> e.getAge() >= age).collect(Collectors.toList());
    }

    public static boolean isAverageAgeEmployee(List<Employee> employee, int average) {
        return employee.stream().allMatch(e -> e.getAge() > average);
    }

    public static Employee getYoungestEmployee(List<Employee> list) {
        return list.stream().min((Employee emp1, Employee emp2) -> {
            if (emp1.getAge() > emp2.getAge()) {
                return 1;
            }
            return -1;
        }).get();
    }
}