package com.example.project1.controllers;

import com.example.project1.classes.Department;
import com.example.project1.classes.Employ;
import com.example.project1.services.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/department/{departmentID}/employ")
public class EmployController {

    private final EmployService employService;

    @Autowired
    public EmployController(EmployService employService) {
        this.employService = employService;
    }

    @GetMapping
    public List<Employ> getEmploys(@PathVariable("departmentID") Long departmentID){
        return employService.getEmploys(departmentID);
    }

    @PostMapping
    public void addEmploys(
            @RequestBody Employ employ,@PathVariable("departmentID") Long departmentID){
         employ.setDepartment(new Department(departmentID));
         employService.addEmploys(employ);
    }

    @DeleteMapping(path="{employId}")
    public void deleteEmploy(@PathVariable("employId") Long employId){

        employService.deleteEmploy(employId);
    }

    @PutMapping(path ="{employId}")
    public void updateEmploy(
            @PathVariable("employId") Long employId,
            @RequestBody Employ employ,
            @PathVariable("departmentID") Long departmentID){
        employ.setDepartment(new Department(departmentID));
        employService.updateEmploy(employId, employ);
    }
}
