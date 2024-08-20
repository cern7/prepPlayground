package lambda;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferencesTest {

    public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>>
    DEST transferElements(
            SOURCE sourceCollection,
            Supplier<DEST> collectionFactory) {
        DEST result = collectionFactory.get();
        for (T t : sourceCollection) {
            result.add(t);
        }
        return result;
    }

    public static void main(String... args) {
        List<Person> roster = Person.createRoster();

        for (Person p : roster) {
            p.printPerson();
        }

        Person[] rosterArray = roster.toArray(new Person[roster.size()]);

        class PersonAgeComparator implements Comparator<Person> {
            public int compare(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        // Without method reference
        Arrays.sort(rosterArray, new PersonAgeComparator());

        // With lambda expression
        Arrays.sort(rosterArray, (Person a, Person b) -> {
            return a.getBirthday().compareTo(b.getBirthday());
        });

        // With method reference
        Arrays.sort(rosterArray, Person::compareByAge);

        // Reference to an instance method of a particular object
        class ComparisonProvider {
            public int compareByName(Person a, Person b) {
                return a.getName().compareTo(b.getName());
            }

            public int compareByAge(Person a, Person b) {
                return a.getBirthday().compareTo(b.getBirthday());
            }
        }

        ComparisonProvider myComparisonProvider = new ComparisonProvider();
        Arrays.sort(rosterArray, myComparisonProvider::compareByName);

        // Reference to an instance method
        // of an arbitrary object of a particular type

        String[] stringArray = {"Barbara", "James", "Mary", "John", "Patricia", "Robert", "Michael", "Linda"};
        Arrays.sort(stringArray, String::compareToIgnoreCase);

        Set<Person> rosterSetLambda = transferElements(roster, () -> {
            return new HashSet<>();
        });

        Set<Person> rosterSet = transferElements(roster, HashSet::new);
        System.out.println("Printing rosterSet:");
        rosterSet
                .stream()
                .forEach(p -> p.printPerson());
    }
}
