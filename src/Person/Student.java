package Person;

public class Student extends Person{

    public Student(String name, String surname) {
        super(name, surname);
    }
    @Override
    public boolean isProfi() {
        return false;
    }
}
