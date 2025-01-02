package az.company.dao;

import az.company.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final String url = "jdbc:h2:~/test";
    ;
    private final String username = "sa";
    private final String password = "";

    private Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(url, username, password);
    }

    public void save(Student student) {

        String sql = "INSERT INTO students (name,surname,age,grade) VALUES(?,?,?,?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getGrade());

            statement.execute();
            System.out.println("Successfully inserted student");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<Student> getAll() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Student student = new Student();
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAge(resultSet.getInt("age"));
                student.setGrade(resultSet.getInt("grade"));
                students.add(student);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return students;
    }

    public void createStudent() {

        try (Connection connection = getConnection();) {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE students " +
                    "(name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " grade INTEGER, " +
                    " age INTEGER)";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
