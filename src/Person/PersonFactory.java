package Person;

import Operations.ReaderCsv;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class PersonFactory {

    private static final List<String[]> listOfNames = ReaderCsv.readCsv("data/names.csv");
    private static final List<String[]> listOfSurnames = ReaderCsv.readCsv("data/surnames.csv");
    private static final List<String[]> listOfProfessorSurnames = ReaderCsv.readCsv("data/professor_surnames.csv");

    public PersonFactory() {
    }

    public static Person createCustomer(String type) {
        switch (type) {
            case "Professor":
                return createProfessor(listOfNames, listOfProfessorSurnames);
            case "Student":
                return createStudent(listOfNames, listOfSurnames);
            default:
                return null;
        }
    }

    private static Person createProfessor(List<String[]> listOfNames, List<String[]> listOfSurnames) {
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

    private static boolean checkSurname(String surname) {
        return !surname.endsWith("î") && !surname.endsWith("ü");
    }

    private static Person createStudent(List<String[]> listOfNames, List<String[]> listOfSurnames) {
        Random r = new Random();
        String[] name = listOfNames.get(r.nextInt(listOfNames.size() - 1));
        String surname = listOfSurnames.get(r.nextInt(listOfSurnames.size() - 1))[0];
        if (Objects.equals(name[1], "F")) surname = surname + "à";
        return new Student(name[0], surname);
    }
}
