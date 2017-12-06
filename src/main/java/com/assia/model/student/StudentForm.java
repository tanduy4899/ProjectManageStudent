package com.assia.model.student;

import com.assia.model.subject.SubjectForm;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;
@Data
public class StudentForm {
    @NotBlank
    private String name;
    @NotBlank
    private String course;
    @NotEmpty
    private List<SubjectForm> subjectForms;
}
