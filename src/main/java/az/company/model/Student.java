package az.company.model;

public class Student {

    private String name;
    private String surname;
    private Integer age;
    private Integer grade;
    private Integer id;

    public Student() {
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String name, String surname, int age, int grade, int birthDate) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.grade = grade;
    }


}
