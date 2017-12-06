package com.assia.model.subject;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigInteger;
@Data
public class SubjectForm {
    @NotBlank
    private String name;
}
