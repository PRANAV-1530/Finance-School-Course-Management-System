package com.examly.springapp.service;

import com.examly.springapp.model.Enrollment;
import java.util.List;

public interface EnrollmentService {

    // Create a new enrollment
    Enrollment addEnrollment(Enrollment enrollment);

    // Get all enrollments
    List<Enrollment> getAllEnrollments();

    // Get enrollment by ID
    Enrollment getEnrollmentById(int id);

    // Update enrollment details
    Enrollment updateEnrollment(int id, Enrollment updatedEnrollment);

    // Delete enrollment by ID
    boolean deleteEnrollment(int id);
}
