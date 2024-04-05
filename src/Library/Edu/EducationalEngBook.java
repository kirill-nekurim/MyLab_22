package Library.Edu;

import Library.EngBook;

public class EducationalEngBook implements EngBook {
    public  String university;
    public String discipline;
    public String author;
    public int year;
    public boolean isBacalavr;

    /*
    � �������� ��������� ����������(�������) ���������� ����������� ��������� ������ � �����������
    isBacalavr - "������������ ������� ���������� ����������� ����� ������� � ��� ������������
     ��� ��� ������������, ������������� ������ �� �����"
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
                    "�����������", year + "���");
            return result;
        }
        String result = String.join(" ", discipline, author, university, "������������", year + "���");
    return result;
    }
}
