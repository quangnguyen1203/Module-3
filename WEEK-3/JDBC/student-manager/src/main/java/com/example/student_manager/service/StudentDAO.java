package com.example.student_manager.service;

import com.example.student_manager.model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements IStudentDAO{
    private String url = "jdbc:mysql:localhost:3306/demo_student?useSSL=false";
    private String username = "root";
    private String password = "admin";

    public StudentDAO(){
    }

    protected  Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    private static final String INSERT_STUDENT_SQL = "INSERT INTO students" + "(name,dob,address,phone,email) VALUES" + "(?,?,?,?,?);";

    @Override
    public void insertStudent(Student student) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
        ) {
            preparedStatement.setString(1,student.getName());
            preparedStatement.setDate(2, (Date) student.getDob());
            preparedStatement.setString(3,student.getAddress());
            preparedStatement.setString(4,student.getPhone());
            preparedStatement.setString(5,student.getEmail());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            printSQLException(e);
        }
    }

    private static final String SELECT_STUDENT_BY_ID = "SELECT * FROM students where id =?";

    @Override
    public Student selectStudent(int id) {
        Student student = null;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT_BY_ID))
        {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                student = new Student(id,name,dob,address,phone,email);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return student;
    }

    private static final String SELECT_ALL_STUDENT = "SELECT * FROM students";

    @Override
    public List<Student> selectAllStudent() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENT)
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                studentList.add(new Student(id,name,dob,address,phone,email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return studentList;
    }

    private static final String SEARCH_STUDENT = "SELECT * FROM students WHERE name like ? or address like ? or phone like ? or email like ?";

    @Override
    public List<Student> searchStudent(String string) {
        List<Student> studentList = new ArrayList<>();
        String keyWord = "%" + string + "%";
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_STUDENT);
        ) {
            System.out.println(preparedStatement);
            preparedStatement.setString(1,keyWord);
            preparedStatement.setString(2,keyWord);
            preparedStatement.setString(3,keyWord);
            preparedStatement.setString(4,keyWord);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                studentList.add(new Student(id,name,dob,address,phone,email));
            }
        } catch (SQLException e){
            printSQLException(e);
        }
        return studentList;
    }

    private static final String SORT_NAME_STUDENT = "SELECT * FROM students ORDER BY name";

    @Override
    public List<Student> sortStudent() {
        List<Student> studentList = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SORT_NAME_STUDENT)
        ) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                studentList.add(new Student(id,name,dob,address,phone,email));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return studentList;
    }

    private static final String DELETE_STUDENT = "DELETE FROM students WHERE id =?";

    @Override
    public boolean deleteStudent(int id) throws SQLException {
        boolean rowDelete;
        try (Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
        ) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        }
        return rowDelete;
    }

    private static final String UPDATE_STUDENT = "UPDATE students set name = ?, dob = ?, address = ?, phone = ?, email = ? where id =?";

    @Override
    public boolean updateStudent(Student student) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setDate(2, (Date) student.getDob());
            preparedStatement.setString(3, student.getAddress());
            preparedStatement.setString(4, student.getPhone());
            preparedStatement.setString(5, student.getEmail());
            preparedStatement.setInt(6, student.getId());

            rowUpdated = preparedStatement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
