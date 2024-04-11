package Operations;

import Counter.EducationalLiteratureFactory;
import Counter.HudLiteratureFactory;
import Library.Book;
import Library.EngBook;
import Library.RuBook;
import Person.Person;
import Person.PersonFactory;
import java.util.*;

public class Creator {
    private static final Random random = new Random();

    private static final String ENGLISH = "ENGLISH";
    private static final String RUSSIAN = "RUSSIAN";

    private static Set<Book> makeSetOfBooks(String type) {
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            if (type.equals(ENGLISH)) {
                books.add(EducationalLiteratureFactory.getInstance().createEngLiterature());
            } else if (type.equals(RUSSIAN)) {
                books.add(HudLiteratureFactory.getInstance().createRuLiterature());
            }
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
        List<Book> allBooks = new ArrayList<>();
        allBooks.addAll(makeSetOfBooks(ENGLISH));
        allBooks.addAll(makeSetOfBooks(RUSSIAN));

        for (Person customer : customers) {
            int numberOfBooks = random.nextInt(3, 11);
            for (int j = 0; j < numberOfBooks; j++) {
                Book randomBook;
                do {
                    randomBook = allBooks.get(random.nextInt(allBooks.size()));
                } while (customer.isBookInList(randomBook));

                if (randomBook instanceof EngBook) {
                    customer.englishBooks.add((EngBook) randomBook);
                } else {
                    customer.russianBooks.add((RuBook) randomBook);
                }
            }
        }
    }
}
