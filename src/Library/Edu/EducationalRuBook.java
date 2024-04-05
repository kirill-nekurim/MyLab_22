package Library.Edu;

import Library.RuBook;

public class EducationalRuBook implements RuBook {
    public String type;
    public int edition;
    public String subject;

    /*
    type -	"В качестве части русскоязычного названия использовать
     несколько вариантов типов литературы (например: Учебник, Пособие, Задачник и т.п.)"
     */
public EducationalRuBook(String type, int edition, String subject){
    this.type = type;
    this.edition= edition;
    this.subject = subject;
}
    @Override
    public String getInfo() {
    String result =  String.join(" ", type, subject, edition + "-е издание");
    return result;
    }
}
