package ru.otus.javabasic.hw11.person;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private final Map<Long, Person> data = new HashMap<>();
    private final EnumSet<Position> managers;

    private final EnumSet<Position> employee;

    public PersonDataBase() {
        managers = EnumSet.of(Position.MANAGER, Position.DIRECTOR,
                Position.BRANCH_DIRECTOR, Position.SENIOR_MANAGER);

        employee = EnumSet.allOf(Position.class);
        employee.removeAll(managers);
    }

    public Person findById(Long id) {
        return data.get(id);
    }

    public void add(Person person) {
        data.put(person.getId(), person);
    }

    public boolean isManager(Person person) {
        return managers.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        Person p = findById(id);
        if (p != null) {
            return employee.contains(p.getPosition());
        }
        return false;
    }
}