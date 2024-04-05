package Library.Edu;

import Library.RuBook;

public class EducationalRuBook implements RuBook {
    public String type;
    public int edition;
    public String subject;

    /*
    type -	"� �������� ����� �������������� �������� ������������
     ��������� ��������� ����� ���������� (��������: �������, �������, �������� � �.�.)"
     */
public EducationalRuBook(String type, int edition, String subject){
    this.type = type;
    this.edition= edition;
    this.subject = subject;
}
    @Override
    public String getInfo() {
    String result =  String.join(" ", type, subject, edition + "-� �������");
    return result;
    }
}
