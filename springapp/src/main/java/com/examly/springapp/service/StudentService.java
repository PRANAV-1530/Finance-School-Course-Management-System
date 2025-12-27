package com.examly.springapp.service;

import com.examly.springapp.model.Student;
import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(Long id);

    Student updateStudent(Long id, Student updatedStudent);

    void deleteStudent(Long id);

    // REQUIRED for Day12_testGetStudentsByEmail
    Student getStudentByEmail(String email);
}
