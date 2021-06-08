package com.example.student_manager.service;

import com.example.student_manager.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDAO {

    public void insertStudent(Student student) throws SQLException;

    public Student selectStudent(int id);

    public List<Student> selectAllStudent();

    public List<Student> searchStudent(String string);

    public List<Student> sortStudent();

    public boolean deleteStudent(int id) throws SQLException;

    public boolean updateStudent(Student student) throws SQLException;
}
