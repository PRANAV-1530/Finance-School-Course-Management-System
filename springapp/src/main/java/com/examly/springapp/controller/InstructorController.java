package com.examly.springapp.controller;

import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.InstructorRepo;
import com.examly.springapp.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private final InstructorService instructorService;

    @Autowired
    private InstructorRepo repo;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }
    @PostMapping
    public ResponseEntity<Instructor> addInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorService.addInstructor(instructor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInstructor);
    }
    @GetMapping
    public ResponseEntity<List<Instructor>> getAllInstructors() {
        List<Instructor> instructors = instructorService.getAllInstructors();
        if (instructors.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(instructors);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable int id) {
        Instructor instructor = instructorService.getInstructorById(id);
        return instructor != null
                ? ResponseEntity.ok(instructor)
                : ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(
            @PathVariable int id,
            @RequestBody Instructor updatedInstructor) {

        Instructor instructor = instructorService.updateInstructor(id, updatedInstructor);

        return instructor != null
                ? ResponseEntity.ok(instructor)
                : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructor(@PathVariable int id) {
        boolean deleted = instructorService.deleteInstructor(id);
        return deleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
    @GetMapping("/page/{offset}/{page}")
    public Page<Instructor> getInstructorWithPage(
            @PathVariable int offset,
            @PathVariable int page) {

        Pageable pageable = PageRequest.of(offset, page);
        return repo.findAll(pageable);
    }

    @GetMapping("/specialization/{specialization}")
public ResponseEntity<?> getInstructorBySpecialization(
        @PathVariable String specialization) {

    List<Instructor> instructors =
            instructorService.getInstructorsBySpecialization(specialization);

    if (instructors == null || instructors.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("No instructors found with specialization: " + specialization);
    }

    return ResponseEntity.ok(instructors);
}
}





