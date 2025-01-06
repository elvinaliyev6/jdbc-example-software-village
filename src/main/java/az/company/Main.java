package az.company;

import az.company.dao.StudentDao;
import az.company.model.Student;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        while (true) {
            System.out.println("What dou want? !. 1. Create Student table\n" +
                    "2. Save Student\n" +
                    "3. Get All Students\n" + "4.Get student by id\n" + "5.Update student by id\n" + "6.Delete student by id");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    studentDao.createStudent();
                    break;
                case 2:
                    Student student = new Student();
                    System.out.println("Enter student ID: ");
                    student.setId(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter student name: ");
                    String name = scanner.next();
                    student.setName(name);
                    System.out.println("Enter student surname: ");
                    String surname = scanner.next();
                    student.setSurname(surname);
                    scanner.nextLine();
                    System.out.println("Enter student age: ");
                    student.setAge(scanner.nextInt());
                    System.out.println("Enter student grade: ");
                    student.setGrade(scanner.nextInt());
                    studentDao.save(student);
                    break;
                case 3:
                    System.out.println(studentDao.getAll());
                    break;
                case 4:
                    System.out.println("Enter student id: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(studentDao.getById(id));
                    break;
                case 5:
                    System.out.println("Enter student id to update: ");
                    int idd = scanner.nextInt();
                    Student st = studentDao.getById(idd);
                    if (st.getId() == null) {
                        throw new RuntimeException("Student not found");
                    }
                    System.out.println(st);
                    scanner.nextLine();
                    System.out.println("Enter student name: ");
                    name = scanner.next();
                    st.setName(name);
                    System.out.println("Enter student surname: ");
                    surname = scanner.next();
                    st.setSurname(surname);
                    System.out.println("Enter student age: ");
                    st.setAge(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Enter student grade: ");
                    st.setGrade(scanner.nextInt());
                    scanner.nextLine();
                    studentDao.updateStudent(st, idd);
                    break;
                case 6:
                    System.out.println("Enter student id: ");
                    id = scanner.nextInt();
                    Student student1 = studentDao.getById(id);
                    if (student1 == null) {
                        throw new RuntimeException("Student not found");
                    }
                    if (student1.getId() == null) {
                        throw new RuntimeException("Student not found");
                    }
                    studentDao.deleteStudent(student1.getId());
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }

    }
}