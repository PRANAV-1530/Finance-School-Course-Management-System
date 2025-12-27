package com.examly.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.examly.springapp.model.Instructor;

import java.util.List;

@Repository
public interface InstructorRepo extends JpaRepository<Instructor, Long> {

    List<Instructor> findBySpecialization(String specialization);
}
    