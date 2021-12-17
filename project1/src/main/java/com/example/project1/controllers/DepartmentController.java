package com.example.project1.controllers;

import com.example.project1.classes.Department;
import com.example.project1.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getDepartment(){
        return departmentService.getDepartments();
    }

    @PostMapping
    public void addDepartment (@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @DeleteMapping(path="{departmentId}")
    public void deleteEmploy(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartment(departmentId);
    }

    @PutMapping(path ="{departmentId}")
    public void updateDepartment(
            @PathVariable("departmentId") Long departmentId,@RequestParam String departmentName){
        departmentService.updateDepartment(departmentId,departmentName);
    }

}
