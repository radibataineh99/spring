package com.example.project1.classes;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity//for hibernate
@Table //for our table in the database
public class Department {

    @Id
    @SequenceGenerator(
            name="department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long departmentId;

    @Column (nullable = false)
    @NotNull
    private int numberOfEmploy;

    @Column(unique = true)
    @NotNull
    private String departmentName;

    @OneToMany(mappedBy = "department" ,orphanRemoval = true,cascade = CascadeType.PERSIST)
    private List<Employ> employs;

    public Department() {
    }

    public Department(Long departmentId) {
        this.departmentId = departmentId;
    }

    /*public Department(String departmentName) {
        this.departmentName = departmentName;
        this.numberOfEmploy=0;
    }*/

    public List<Employ> getEmploys() {
        return employs;
    }

    public void setEmploys(List<Employ> employs) {
        this.employs = employs;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public int getNumberOfEmploy() {
        return numberOfEmploy;
    }

    public void addEmployToDepartment()
    {
        this.numberOfEmploy+=1;
    }
}
