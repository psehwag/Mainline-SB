package com.optrident.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.optrident.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, String> {

}
