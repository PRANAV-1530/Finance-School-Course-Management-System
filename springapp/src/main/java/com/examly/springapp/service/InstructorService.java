package com.examly.springapp.service;

import com.examly.springapp.model.Instructor;
import java.util.List;

public interface InstructorService {

    Instructor addInstructor(Instructor instructor);

    List<Instructor> getAllInstructors();

    Instructor getInstructorById(int id);

    Instructor updateInstructor(int id, Instructor instructor);

    boolean deleteInstructor(int id);

    // REQUIRED FOR DAY 12
    List<Instructor> getInstructorsBySpecialization(String specialization);
}
