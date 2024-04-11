package Person;

import Library.Book;
import Library.EngBook;
import Library.RuBook;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Person {
    public String name;
    public String surname;
    public List<EngBook> englishBooks;
    public List<RuBook> russianBooks;
    private Map<Book, Object> issuedBooks = new HashMap<>();

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        englishBooks = new ArrayList<>();
        russianBooks = new ArrayList<>();
    }



    public boolean isBookInList(Book book) {
        return issuedBooks.containsKey(book);
    }

    public boolean isEngBookInList(EngBook book) {
        return isBookInList(book);
    }

    public boolean isRuBookInList(RuBook book) {
        return isBookInList(book);
    }

    public DefaultMutableTreeNode createNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(getInfo());
        for (EngBook englishBook : englishBooks) {
            node.add(new DefaultMutableTreeNode(englishBook.getInfo()));
        }
        for (RuBook russianBook : russianBooks) {
            node.add(new DefaultMutableTreeNode(russianBook.getInfo()));
        }
        return node;
    }


    public String getInfo() {
        return name + " " + surname;
    }

    public abstract boolean isProfi();
}
