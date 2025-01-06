package az.company.dao;

import az.company.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "K02Xw3g9";

    private Connection getConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    public void save(Student student) {

        String sql = "INSERT INTO students (id, name,surname,age,grade) VALUES(?,?,?,?,?)";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setInt(1, student.getId());
            statement.setString(2, student.getName());
            statement.setString(3, student.getSurname());
            statement.setInt(4, student.getAge());
            statement.setInt(5, student.getGrade());
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

                student.setId(resultSet.getInt("id"));
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

    public Student getById(int id) {
        String sql = "SELECT * FROM students " +
                "WHERE id = ?";
        Student student = new Student();
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                student = new Student();

                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAge(resultSet.getInt("age"));
                student.setGrade(resultSet.getInt("grade"));
            }
            return student.getId() == null ? null : student;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return student;
    }

    public void createStudent() {

        try (Connection connection = getConnection();) {
            Statement stmt = connection.createStatement();
            String sql = "CREATE TABLE students " +
                    "(id INTEGER, " +
                    "name VARCHAR(255), " +
                    " surname VARCHAR(255), " +
                    " grade INTEGER, " +
                    " age INTEGER)";
            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateStudent(Student student, int id) {
        String sql = "UPDATE students set name = ?, surname = ?, age = ?, grade = ? WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setInt(3, student.getAge());
            statement.setInt(4, student.getGrade());
            statement.setInt(5, student.getId());
            statement.executeUpdate();
            System.out.println("Successfully updated student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id = ?";
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection
                    .prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
            System.out.println("Successfully deleted student");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
