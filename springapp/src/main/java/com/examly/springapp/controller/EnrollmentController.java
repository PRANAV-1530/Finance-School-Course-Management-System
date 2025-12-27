package com.examly.springapp.controller;

import com.examly.springapp.model.Enrollment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/api/enrollments")  // ✅ Added class-level RequestMapping
public class EnrollmentController {

    private List<Enrollment> enrollmentList = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<String> createEnrollment(@RequestBody(required = false) Enrollment enrollment) {
        if (enrollment == null) {
            return new ResponseEntity<>("Request body is missing", HttpStatus.BAD_REQUEST);
        }
        enrollmentList.add(enrollment);
        return new ResponseEntity<>("Enrollment created", HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        if (enrollmentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(enrollmentList, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEnrollment(@PathVariable int id, @RequestBody Enrollment updatedEnrollment) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId() == id) {
                enrollment.setCourseId(updatedEnrollment.getCourseId());
                enrollment.setStudentId(updatedEnrollment.getStudentId());
                enrollment.setStatus(updatedEnrollment.getStatus());
                return new ResponseEntity<>("Enrollment updated", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Enrollment not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEnrollment(@PathVariable int id) {
        Iterator<Enrollment> iterator = enrollmentList.iterator();
        while (iterator.hasNext()) {
            Enrollment enrollment = iterator.next();
            if (enrollment.getId() == id) {
                iterator.remove(); // safe removal
                return new ResponseEntity<>("Enrollment deleted", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Enrollment not found", HttpStatus.NOT_FOUND);
    }
}
