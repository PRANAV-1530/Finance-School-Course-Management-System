package com.examly.springapp.service;

import com.examly.springapp.model.Enrollment;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    private List<Enrollment> enrollmentList = new ArrayList<>();

    @Override
    public Enrollment addEnrollment(Enrollment enrollment) {
        enrollmentList.add(enrollment);
        return enrollment;
    }

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentList;
    }

    @Override
    public Enrollment getEnrollmentById(int id) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId() == id) {
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public Enrollment updateEnrollment(int id, Enrollment updatedEnrollment) {
        for (Enrollment enrollment : enrollmentList) {
            if (enrollment.getId() == id) {
                enrollment.setCourseId(updatedEnrollment.getCourseId());
                enrollment.setStudentId(updatedEnrollment.getStudentId());
                enrollment.setStatus(updatedEnrollment.getStatus());
                return enrollment;
            }
        }
        return null;
    }

    @Override
    public boolean deleteEnrollment(int id) {
        return enrollmentList.removeIf(enrollment -> enrollment.getId() == id);
    }
}
