package Operations;

import Counter.EducationalLiteratureFactory;
import Counter.HudLiteratureFactory;
import Library.EngBook;
import Library.RuBook;
import Person.Person;
import Person.PersonFactory;
import java.util.*;

public class Creator {
    private static final Random random = new Random();

    private static Set<EngBook> makeSetOfEngBooks() {
        Set<EngBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? EducationalLiteratureFactory.getInstance().createEngLiterature() :
                    HudLiteratureFactory.getInstance().createEngLiterature());
        }
        return books;
    }

    private static Set<RuBook> makeSetOfRuBooks() {
        Set<RuBook> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            books.add(random.nextBoolean() ? HudLiteratureFactory.getInstance().createRuLiterature() :
                    EducationalLiteratureFactory.getInstance().createRuLiterature());
        }
        return books;
    }

    private static List<Person> makeListOfCustomers(int numberOfCustomers) {
        List<Person> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(random.nextBoolean() ? PersonFactory.getInstance().createCustomer("Professor") :
                    PersonFactory.getInstance().createCustomer("Student"));
        }
        return customers;
    }

    public static Person[] generateCustomers(int numberOfCustomers) {
        List<Person> listOfCustomers = makeListOfCustomers(numberOfCustomers);
        Person[] customers = new Person[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            customers[i] = listOfCustomers.get(i);
        }
        distributeBooks(customers);
        return customers;
    }

    private static void distributeBooks(Person[] customers) {
        List<EngBook> engBooks = new ArrayList<>(makeSetOfEngBooks());
        List<RuBook> ruBooks = new ArrayList<>(makeSetOfRuBooks());
        for (Person customer : customers) {
            int numberOfBooks = random.nextInt(3, 11);
            int item;
            for (int j = 0; j < numberOfBooks; j++) {
                if (random.nextBoolean()) {
                    do {
                        item = random.nextInt(engBooks.size());
                    } while (customer.isEngBookInList(engBooks.get(item)));
                    customer.englishBooks.add(engBooks.get(item));
                } else {
                    do {
                        item = random.nextInt(ruBooks.size());
                    } while (customer.isRuBookInList(ruBooks.get(item)));
                    customer.russianBooks.add(ruBooks.get(item));
                }
            }
        }
    }
}
