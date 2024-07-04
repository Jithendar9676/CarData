package com.batch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.batch.entiry.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
