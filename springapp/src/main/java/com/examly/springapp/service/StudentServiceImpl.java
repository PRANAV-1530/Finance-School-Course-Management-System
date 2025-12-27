package com.examly.springapp.service;

import com.examly.springapp.model.Student;
import com.examly.springapp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepo.findById(id).map(existing -> {
            existing.setStudentName(updatedStudent.getStudentName());
            existing.setEmail(updatedStudent.getEmail());
            existing.setPhoneNumber(updatedStudent.getPhoneNumber());
            existing.setAddress(updatedStudent.getAddress());
            return studentRepo.save(existing);
        }).orElse(null);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentRepo.findByEmail(email);
    }
}
