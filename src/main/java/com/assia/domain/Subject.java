package com.assia.domain;

import com.assia.model.subject.SubjectModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "idStudent")
    private Student student;

    public SubjectModel toSubjectModel(){
        SubjectModel rs = new SubjectModel();
        rs.setId(id);
        rs.setName(name);
        return rs;
    }
}
