package com.examly.springapp.service;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public Instructor addInstructor(Instructor instructor) {
        return instructorRepo.save(instructor);
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return instructorRepo.findAll();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepo.findById((long) id).orElse(null);
    }

    @Override
    public Instructor updateInstructor(int id, Instructor updatedInstructor) {
        return instructorRepo.findById((long) id).map(existing -> {
            existing.setInstructorName(updatedInstructor.getInstructorName());
            existing.setEmail(updatedInstructor.getEmail());
            existing.setSpecialization(updatedInstructor.getSpecialization());
            existing.setPhoneNumber(updatedInstructor.getPhoneNumber());
            existing.setDepartment(updatedInstructor.getDepartment());
            return instructorRepo.save(existing);
        }).orElse(null);
    }

    @Override
    public boolean deleteInstructor(int id) {
        if (instructorRepo.existsById((long) id)) {
            instructorRepo.deleteById((long) id);
            return true;
        }
        return false;
    }

    @Override
    public List<Instructor> getInstructorsBySpecialization(String specialization) {
        return instructorRepo.findBySpecialization(specialization);
    }
}
