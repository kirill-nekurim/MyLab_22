import Operations.Creator;
import Operations.GUI;
import Person.PersonFactory;

public class Main {
    public static void main(String[] args) {
        PersonFactory personFactory = new PersonFactory();
        Creator creator = new Creator(personFactory); // Создаем Creator с PersonFactory
        new GUI(creator); // Передаем Creator в конструктор GUI
    }
}
