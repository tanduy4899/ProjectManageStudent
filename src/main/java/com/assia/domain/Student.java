package com.assia.domain;

import com.assia.model.student.StudentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String name;
    private String course;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Subject> subjects = new ArrayList<>();

    public StudentModel toStudentModel(){
        StudentModel rs = new StudentModel();
        rs.setId(id);
        rs.setName(name);
        rs.setCourse(course);
        rs.setSubjectModels(getSubjects().stream().map(Subject::toSubjectModel).collect(Collectors.toList()));
        return rs;
    }
}
