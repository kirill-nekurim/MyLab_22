package Person;

import Library.EngBook;
import Library.RuBook;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.util.List;

public abstract class Person  {
    public String name;
    public String surname;
    public List<EngBook> englishBooks;
    public List<RuBook> russianBooks;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        englishBooks = new ArrayList<>();
        russianBooks = new ArrayList<>();
    }

    public boolean isEngBookInList(EngBook newBook) {
        for (EngBook englishBook : englishBooks) {
            if (newBook.equals(englishBook)) return true;
        }
        return false;
    }

    public boolean isRuBookInList(RuBook newBook) {
        for (RuBook russianBook : russianBooks) {
            if (newBook.equals(russianBook)) return true;
        }
        return false;
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
