package Counter;

import Library.Edu.EducationalRuBook;
import Library.Edu.EducationalEngBook;

import Library.EngBook;
import Library.RuBook;
import Operations.ReaderCsv;

import java.util.List;
import java.util.Random;

public class EducationalLiteratureFactory implements AbstractFactory{
    List<String[]> ListOfSubject;
    private static EducationalLiteratureFactory INSTANCE;

    private EducationalLiteratureFactory() {
        ListOfSubject = ReaderCsv.readCsv("data/disciplines.csv");
    }

    public static EducationalLiteratureFactory getInstance(){
        if(INSTANCE == null) {
            INSTANCE = new EducationalLiteratureFactory();
    }
        return INSTANCE;
    }
    @Override
    public RuBook createRuLiterature() {
        String[] types = {
                "Задачник", "Учебник", "Пособие"
        };
        Random r = new Random();
        String type = types[r.nextInt(types.length - 1)];
        int edition = r.nextInt(3) + 1;
        return new EducationalRuBook(type, edition, ListOfSubject.get(3)[r.nextInt(ListOfSubject.get(3).length - 1)]);
    }

    @Override
    public EngBook createEngLiterature() {
        Random r = new Random();
        boolean isBachelor = r.nextBoolean();
        int year = r.nextInt(1950, 2024);
        String author, university, discipline;
        discipline = ListOfSubject.get(0)[r.nextInt(ListOfSubject.get(0).length - 1)];
        author = ListOfSubject.get(1)[r.nextInt(ListOfSubject.get(1).length - 1)];
        university = ListOfSubject.get(2)[r.nextInt(ListOfSubject.get(2).length - 1)];
        return new EducationalEngBook(author, year, discipline, university, isBachelor);
    }
}
