package com.assia.service;

import com.assia.domain.Student;
import com.assia.model.student.StudentForm;
import com.assia.model.student.StudentModel;
import com.assia.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Student> getById(BigInteger id){
        return this.studentRepository.getById(id);
    }

    public Optional<Student> update(BigInteger id,StudentForm studentForm){
        return this.getById(id).map(student -> {
            student.setName(studentForm.getName());
            student.setCourse(studentForm.getCourse());
            return this.studentRepository.save(student);
        });
    }

    public Student create(StudentForm studentForm){
        Student student = new Student();
        student.setName(studentForm.getName());
        student.setCourse(studentForm.getCourse());
        return this.studentRepository.save(student);
    }
}
