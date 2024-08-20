package lambda;

import java.util.ArrayList;
import java.util.List;

import static lambda.RosterTest.*;

public class Main {

    public static void main(String[] args) {
        int n = 10;

        List<Person> roster = new ArrayList<>();

        printPersons(roster, x -> x.getAge() >= x.getAge());

        printPersons(roster,
                (Person p) -> p.getAge() >= 18);
        printPersonsWithPredicate(roster,
                (Person p) -> p.getAge() >= 18);

        processPersons(roster,
                person -> person.getAge() >= 18,
                person -> person.printPerson());

        processPersonWithFunction(roster,
                p -> p.getAge() >= 18,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));


        processElements(roster,
                p -> {
                    return p.getAge() >= 18;
                },
                p -> p.getEmailAddress(),
                email -> System.out.println(email));


        roster
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(p -> p.getEmailAddress())
                .forEach(email -> System.out.println(email));
    }


}
