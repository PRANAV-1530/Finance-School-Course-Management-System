package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Course;
import com.examly.springapp.repository.CourseRepo;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.findById(id).orElse(null);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        course.setCourseId(id);
        return courseRepo.save(course);
    }

    @Override
    public List<Course> getCoursesByInstructor(Long instructorId) {
        return courseRepo.findByInstructor_InstructorId(instructorId);
    }

    @Override
    public List<Course> getCoursesByLevel(String level) {
        return courseRepo.findByLevel(level);
    }
}
