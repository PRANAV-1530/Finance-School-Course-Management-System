package com.examly.springapp.controller;

import com.examly.springapp.model.Course;
import com.examly.springapp.model.Instructor;
import com.examly.springapp.repository.CourseRepo;
import com.examly.springapp.repository.InstructorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepo repo;

    @Autowired
    private InstructorRepo instructorRepo;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {

        if (course.getInstructor() != null &&
            course.getInstructor().getInstructorId() != null) {

            Instructor instructor = instructorRepo
                .findById(course.getInstructor().getInstructorId())
                .orElseThrow(() ->
                    new RuntimeException("Instructor not found")
                );

            course.setInstructor(instructor);
        }

        Course saved = repo.save(course);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = repo.findAll();
        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = repo.findById(id);
        return course
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(
        @PathVariable Long id,
        @RequestBody Course updatedCourse) {

    return repo.findById(id).map(course -> {

        course.setCourseName(updatedCourse.getCourseName());
        course.setDescription(updatedCourse.getDescription());
        course.setDuration(updatedCourse.getDuration());
        course.setPrice(updatedCourse.getPrice());
        course.setLevel(updatedCourse.getLevel());

        if (updatedCourse.getInstructor() != null &&
            updatedCourse.getInstructor().getInstructorId() != null) {

            Instructor instructor = instructorRepo
                    .findById(updatedCourse.getInstructor().getInstructorId())
                    .orElse(null);

            course.setInstructor(instructor);
        }

        Course saved = repo.save(course);
        return new ResponseEntity<>(saved, HttpStatus.OK);

    }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<Course>> getCoursesByInstructor(
            @PathVariable Long instructorId) {

        List<Course> courses = repo.findByInstructor_InstructorId(instructorId);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/level/{level}")
    public ResponseEntity<?> getCoursesByLevel(@PathVariable String level) {

        List<Course> courses = repo.findByLevel(level);

        if (courses.isEmpty()) {
            return new ResponseEntity<>(
                    "No courses found at level: " + level,
                    HttpStatus.NO_CONTENT
            );
        }

        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}


   