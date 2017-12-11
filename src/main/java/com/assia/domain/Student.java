package com.assia.domain;

import com.assia.model.student.StudentModel;
import com.assia.model.subject.SubjectForm;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.util.CollectionUtils;

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

    public void setListSubjectForm(List<SubjectForm> listSubjectForm){
        subjects.clear();
        if(!CollectionUtils.isEmpty(listSubjectForm)){
            for(int i =0;i<listSubjectForm.size();i++){
                SubjectForm subjectForm = listSubjectForm.get(i);
                Subject subject = new Subject();
                subject.setName(subjectForm.getName());
                subjects.add(subject);
            }
        }
    }
}
