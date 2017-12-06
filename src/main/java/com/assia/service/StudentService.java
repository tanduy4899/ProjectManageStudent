package com.assia.service;

import com.assia.domain.Student;
import com.assia.model.student.StudentModel;
import com.assia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentService{
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentModel> getAll(){
        List<StudentModel> rs = new ArrayList<>();
        this.studentRepository.findAll().forEach(student -> {
            rs.add(student.toStudentModel());
        });
        return rs;
    }
}
