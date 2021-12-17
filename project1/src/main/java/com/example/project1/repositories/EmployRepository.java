package com.example.project1.repositories;

import com.example.project1.classes.Employ;
import com.example.project1.classes.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployRepository extends CrudRepository<Employ,Long> {

     List<Employ> findEmployByDepartmentDepartmentId(Long departmentID);
}
