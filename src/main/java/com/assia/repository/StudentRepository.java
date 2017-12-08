package com.assia.repository;

import com.assia.domain.Student;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student,BigInteger> {

    Optional<Student> getById(BigInteger id);
}
