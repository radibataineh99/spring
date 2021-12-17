package com.example.project1.services;

import com.example.project1.classes.Employ;
import com.example.project1.repositories.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployService {


    private final EmployRepository employRepository;

    @Autowired
    public EmployService(EmployRepository employRepository) {
        this.employRepository = employRepository;
    }

    public List<Employ> getEmploys(Long departmentID){
          List<Employ> employs =new ArrayList<>();
          employRepository.findEmployByDepartmentDepartmentId(departmentID).forEach(employs::add);
          return employs;
    }

    public void addEmploys(Employ employ){
        employRepository.save(employ);
    }

    public void deleteEmploy(Long employId) {
        boolean exists =employRepository.existsById(employId);
        if(!exists){
            throw new IllegalStateException(
                    "Employ with id "+employId+" does not exists");

        }
        employRepository.deleteById(employId);
    }

    @Transactional
    public void updateEmploy(Long employId,Employ employ) {

        Employ employ1 = employRepository.findById(employId)
                .orElseThrow(()-> new IllegalStateException (
                        "employ with id "+employId+" does not exit"));

        if(employ.getFirstName() != null && employ.getLastName() != null &&
                employ.getJobName() != null && employ.getEmail() != null){
            employ1.setFirstName(employ.getFirstName());
            employ1.setLastName(employ.getLastName());
            employ1.setDob(employ.getDob());
            employ1.setJoiningDating(employ.getJoiningDating());
            employ1.setJobName(employ.getJobName());
            employ1.setEmail(employ.getEmail());
    }}
}
