package lambda;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }



    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;


    Person(String nameArg, LocalDate birthdayArg,
           Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }
    public int getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }

    public void printPerson() {
        System.out.printf("Name: %s\nAge: %d\nEmail address: %s\n", this.name, this.getAge(), emailAddress);
    }


    public String getEmailAddress() {
        return this.emailAddress;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public String getName() {
        return this.name;
    }
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    public static List<Person> createRoster() {

        List<Person> roster = new ArrayList<>();
        roster.add(
                new Person(
                        "Fred",
                        IsoChronology.INSTANCE.date(1980, 6, 20),
                        Person.Sex.MALE,
                        "fred@example.com"));
        roster.add(
                new Person(
                        "Jane",
                        IsoChronology.INSTANCE.date(1990, 7, 15),
                        Person.Sex.FEMALE, "jane@example.com"));
        roster.add(
                new Person(
                        "George",
                        IsoChronology.INSTANCE.date(1991, 8, 13),
                        Person.Sex.MALE, "george@example.com"));
        roster.add(
                new Person(
                        "Bob",
                        IsoChronology.INSTANCE.date(2000, 9, 12),
                        Person.Sex.MALE, "bob@example.com"));

        return roster;
    }
}
