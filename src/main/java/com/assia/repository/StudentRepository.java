package com.assia.repository;

import com.assia.domain.Student;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface StudentRepository extends CrudRepository<Student,BigInteger> {

}
