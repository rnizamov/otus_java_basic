package ru.otus.javabasic.hw9;

import java.util.*;
import java.util.stream.Collectors;

public class HomeWork9 {
    public static List<Integer> getRangeList(int min, int max) {
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
        return employees.stream().map(Employee::getName).collect(Collectors.toList());
    }

    public static List<Employee> getEmployeeWithAgeGreaterOrEqualsThan(List<Employee> list, int age) {
        return list.stream().filter(e -> e.getAge() >= age).collect(Collectors.toList());
    }

    public static boolean isAverageAgeEmployeeGreaterThan(List<Employee> employee, double average) {
        OptionalDouble opt = employee.stream().mapToInt(e->e.getAge()).average() ;
        if (opt.isPresent()) {
            return opt.getAsDouble() > average;
        }
        return false;
    }

    public static Employee getYoungestEmployee(List<Employee> list) {
        Optional<Employee> opt = list.stream().min(Comparator.comparingInt(Employee::getAge));
        return opt.orElse(null);
    }
}