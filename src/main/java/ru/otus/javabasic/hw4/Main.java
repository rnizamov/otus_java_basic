package ru.otus.javabasic.hw4;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        User[] users = {
                new User("Киркоров", "Даниил", "Иванович",
                        LocalDate.of(1959, 1, 2), "dan@mail.ru"),
                new User("Валиков", "Иван", "Геннадьевич",
                        LocalDate.of(1969, 2, 22), "ivan@mail.ru"),
                new User("Маликов", "Василий", "Игоревич",
                        LocalDate.of(1979, 3, 21), "vas@mail.ru"),
                new User("Гавриков", "Даниил", "Сергеевич",
                        LocalDate.of(1983, 4, 12), "dany@mail.ru"),
                new User("Петров", "Василий", "Иванович",
                        LocalDate.of(1999, 5, 8), "vas@mail.ru"),
                new User("Валиков", "Иван", "Петрович",
                        LocalDate.of(2000, 6, 2), "iva@mail.ru"),
                new User("Киркоров", "Даниил", "Иванович",
                        LocalDate.of(2001, 7, 8), "danny@mail.ru"),
                new User("Гавриков", "Олег", "Геннадьевич",
                        LocalDate.of(2003, 8, 11), "ole@mail.ru"),
                new User("Киркоров", "Иван", "Игоревич",
                        LocalDate.of(2020, 9, 28), "ivan007@mail.ru"),
                new User("Валиков", "Перт", "Петрович",
                        LocalDate.of(1983, 11, 28), "petr@mail.ru"),
        };

        for (User user : users) {
            LocalDate dateOfBirth = user.getDateOfBirth();
            boolean moreThan40Years = dateOfBirth.plusYears(40).isBefore(LocalDate.now());
            if (moreThan40Years) {
                user.printInfo();
                System.out.println();
            }
        }

        BlackBox box = new BlackBox(200, 200, "black");
        box.open();
        box.add("другая коробка");
        box.close();
        box.clear();
        box.open();
        box.add("еще одна коробочка");
        box.clear();
        box.add("кот");
    }
}




