package ru.otus.javabasic.hw4;

import java.time.LocalDate;

public class User {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String email;
    private LocalDate dateOfBirth;

    public User(String lastName, String firstName, String patronymic, LocalDate dateOfBirth, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public void printInfo() {
        String template = String.format(
                "ФИО: %s %s %s %nГод рождения: %d.%d.%d %ne-mail: %s",
                lastName, firstName, patronymic, dateOfBirth.getYear(), dateOfBirth.getMonthValue(), dateOfBirth.getDayOfMonth(), email);
        System.out.println(template);
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
