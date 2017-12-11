package com.assia.service;

import com.assia.domain.Student;
import com.assia.domain.Subject;
import com.assia.model.student.StudentForm;
import com.assia.model.student.StudentModel;
import com.assia.model.subject.SubjectForm;
import com.assia.repository.StudentRepository;
import com.assia.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService{
    private final StudentRepository studentRepository;

    private final SubjectRepository subjectRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository, SubjectRepository subjectRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
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
            student.getSubjects().clear();
            if(studentForm.getSubjectForms() !=null){
                for(SubjectForm subjectForm : studentForm.getSubjectForms()){
                    Subject subject = subjectRepository.findOne(id);
                    subject.setStudent(student);
                    subject.setName(subjectForm.getName());
                    student.getSubjects().add(subject);
                }
            }

            return this.studentRepository.save(student);
        });
    }

    public Student create(StudentForm studentForm){
        Student student = new Student();
        student.setName(studentForm.getName());
        student.setCourse(studentForm.getCourse());
        student.setListSubjectForm(studentForm.getSubjectForms());
        return this.studentRepository.save(student);
    }

    public void delete(BigInteger id){
        this.getById(id).ifPresent(studentRepository::delete);
    }
}
