package Person;

public class Professor extends Person{

    private final String patronymic;
    public Professor(String name,  String patronymic, String surname) {
        super(name, surname);
        this.patronymic = patronymic;
    }
    @Override
    public boolean isProfi() {
        return true;
    }

    public String getInfo(){
        return name + " " + patronymic + " " + surname;
    }
}
