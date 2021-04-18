package com.Duane.springrosterI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Duane.springrosterI.models.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{}
