package com.example.project1.services;

import com.example.project1.classes.Department;
import com.example.project1.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments(){
        List<Department> departments =new ArrayList<>();
        departmentRepository.findAll().forEach(departments::add);
        return departments;
    }

    public void addDepartment(Department department) {
        Optional<Department> departmentOptional =
                departmentRepository.findBydepartmentName(department.getDepartmentName());
        if(departmentOptional.isPresent()){
            throw new IllegalStateException("name is taken");
        }
        departmentRepository.save(department);
    }

    public void deleteDepartment(Long departmentId) {
        boolean exists =departmentRepository.existsById(departmentId);
        if(!exists){
            throw new IllegalStateException(
                    "Department with id "+departmentId+" does not exists");

        }
        departmentRepository.deleteById(departmentId);
    }

    @Transactional
    public void updateDepartment(Long departmentId, String name) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new IllegalStateException (
                        "Department with id "+departmentId+" does not exit"));
        if(name != null &&
                name.length()>0 &&
                !Objects.equals(department.getDepartmentName(),name)){
            department.setDepartmentName(name);
        }
    }
}
