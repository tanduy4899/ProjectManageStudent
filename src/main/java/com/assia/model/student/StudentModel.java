package com.assia.model.student;

import com.assia.model.subject.SubjectForm;
import com.assia.model.subject.SubjectModel;
import lombok.Data;

import java.math.BigInteger;
import java.util.List;
@Data
public class StudentModel {
    private BigInteger id;
    private String name;
    private String course;
    private List<SubjectModel> subjectModels;
}
