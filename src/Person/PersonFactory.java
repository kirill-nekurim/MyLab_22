package Person;

import Operations.ReaderCsv;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonFactory {
    private static PersonFactory INSTANCE;
    private List<String[]> listOfNames;
    private List<String[]> listOfSurnames;
    private List<String[]> listOfProfessorSurnames;


    private PersonFactory() {
        listOfProfessorSurnames = ReaderCsv.readCsv("data/professor_surnames.csv");
        listOfNames = ReaderCsv.readCsv("data/names.csv");
        listOfSurnames = ReaderCsv.readCsv("data/surnames.csv");
    }

    public static PersonFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersonFactory();
        }
        return INSTANCE;
    }

    public Person createCustomer(String type) {
        return switch (type) {
            case "Professor" -> createProfessor(listOfNames, listOfProfessorSurnames);
            case "Student" -> createStudent(listOfNames, listOfSurnames);
            default -> null;
        };
    }

    private Person createProfessor(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        String[] nameForPatronymics;
        String patronymics;
        do {
            nameForPatronymics = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        } while (Objects.equals(nameForPatronymics[1], "F"));
        if (Objects.equals(name[1], "F")) {
            if (checkSurname(surname)) surname = surname + "à";
            patronymics = nameForPatronymics[3];
        } else patronymics = nameForPatronymics[2];
        return new Professor(name[0], patronymics, surname);
    }

    private boolean checkSurname(String surname) {
        return !surname.endsWith("î") && !surname.endsWith("ü");
    }

    private Person createStudent(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        if (Objects.equals(name[1], "F")) surname = surname + "à";
        return new Student(name[0], surname);
    }
}
