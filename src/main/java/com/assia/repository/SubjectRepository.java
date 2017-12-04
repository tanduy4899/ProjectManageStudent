package com.assia.repository;

import com.assia.domain.Subject;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;

public interface SubjectRepository extends CrudRepository<Subject, BigInteger> {
}
