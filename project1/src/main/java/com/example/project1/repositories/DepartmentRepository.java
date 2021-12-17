package com.example.project1.repositories;

import com.example.project1.classes.Department;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DepartmentRepository extends CrudRepository<Department,Long> {

    Optional<Department> findBydepartmentName(String name);
}
