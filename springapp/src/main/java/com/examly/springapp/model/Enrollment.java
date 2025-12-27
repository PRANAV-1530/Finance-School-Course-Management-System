package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;

@Entity
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long enrollmentId;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Student student;

    private String status;

    // Default constructor
    public Enrollment() {
    }

    // Parameterized constructor (optional)
    public Enrollment(Long enrollmentId, Course course, Student student, String status) {
        this.enrollmentId = enrollmentId;
        this.course = course;
        this.student = student;
        this.status = status;
    }

    // Getters and Setters
    public Long getEnrollmentId() {
        return enrollmentId;
    }

    public void setEnrollmentId(Long enrollmentId) {
        this.enrollmentId = enrollmentId;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public Object getStudentId() {
  
        throw new UnsupportedOperationException("Unimplemented method 'getStudentId'");
    }

    public Object getCourseId() {
 
        throw new UnsupportedOperationException("Unimplemented method 'getCourseId'");
    }

    public void setCourseId(Object courseId) {
   
        throw new UnsupportedOperationException("Unimplemented method 'setCourseId'");
    }

    public void setStudentId(Object studentId) {
   
        throw new UnsupportedOperationException("Unimplemented method 'setStudentId'");
    }
}
