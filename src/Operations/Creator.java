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

    private final PersonFactory personFactory;

    public Creator(PersonFactory personFactory) {
        this.personFactory = personFactory;
    }

    private static Set<Book> makeSetOfBooks(String type, EducationalLiteratureFactory factory) {
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < 60; i++) {
            if (type.equals(ENGLISH)) {
                books.add(factory.createEngLiterature());
            } else if (type.equals(RUSSIAN)) {
                books.add(factory.createRuLiterature());
            }
        }
        return books;
    }

    public static List<Person> makeListOfCustomers(int numberOfCustomers, PersonFactory personFactory) {
        List<Person> customers = new ArrayList<>();
        for (int i = 0; i < numberOfCustomers; i++) {
            customers.add(personFactory.createCustomer(random.nextBoolean() ? "Professor" : "Student"));
        }
        return customers;
    }

    public static Person[] generateCustomers(int numberOfCustomers, PersonFactory personFactory) {
        List<Person> listOfCustomers = makeListOfCustomers(numberOfCustomers, personFactory);
        Person[] customers = new Person[numberOfCustomers];
        for (int i = 0; i < numberOfCustomers; i++) {
            customers[i] = listOfCustomers.get(i);
        }
        distributeBooks(customers);
        return customers;
    }

    private static void distributeBooks(Person[] customers) {
        List<Book> allBooks = new ArrayList<>();
        allBooks.addAll(makeSetOfBooks(ENGLISH, new EducationalLiteratureFactory()));  // Создаем экземпляр EducationalLiteratureFactory для английских книг
        allBooks.addAll(makeSetOfBooks(RUSSIAN, new HudLiteratureFactory()));  // Создаем экземпляр HudLiteratureFactory для художественной литературы

        for (Person customer : customers) {
            int numberOfBooks = random.nextInt(3, 11);
            for (int j = 0; j < numberOfBooks; j++) {
                Book randomBook = allBooks.get(random.nextInt(allBooks.size()));
                if (!customer.isBookInList(randomBook)) {
                    try {
                        customer.englishBooks.add((EngBook) randomBook);
                    } catch (ClassCastException e) {
                        customer.russianBooks.add((RuBook) randomBook);
                    }
                }
            }
        }
    }
}
