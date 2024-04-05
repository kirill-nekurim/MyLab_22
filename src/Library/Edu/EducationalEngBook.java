package Library.Edu;

import Library.EngBook;

public class EducationalEngBook implements EngBook {
    public  String university;
    public String discipline;
    public String author;
    public int year;
    public boolean isBacalavr;

    /*
    В качестве параметра английской(учебной) литературы обязательно указывать автора и университет
    isBacalavr - "Англоязычная учебная литература обязательно имеет уровень — для бакалавриата
     или для магистратуры, русскоязычная уровня не имеет"
     */
    public EducationalEngBook(String author, int year, String discipline, String university, boolean isBacalavr) {
        this.author = author;
        this.year = year;
        this.discipline = discipline;
        this.university = university;
        this.isBacalavr = isBacalavr;
    }

    @Override
    public String getInfo() {
        if (isBacalavr ) {
            String result =  String.join(" ", discipline, author, university,
                    "бакалавриат", year + "год");
            return result;
        }
        String result = String.join(" ", discipline, author, university, "магистратура", year + "год");
    return result;
    }
}
