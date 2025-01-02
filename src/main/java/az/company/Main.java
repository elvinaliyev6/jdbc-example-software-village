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
                    "3. Get All Students");

            Scanner scanner = new Scanner(System.in);

            switch (scanner.nextInt()) {
                case 1:
                    studentDao.createStudent();
                    break;
                case 2:
                    Student student = new Student();
                    System.out.println("Enter student name: ");
                    student.setName(scanner.nextLine());
                    System.out.println("Enter student surname: ");
                    student.setSurname(scanner.nextLine());
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
                default:
                    System.out.println("Invalid option");
            }
        }

    }
}