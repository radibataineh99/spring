package com.example.project1.classes;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;

@Entity//for hibernate
@Table //for our table in the database

public class Employ {

    @Id
    @SequenceGenerator(
            name="employ_sequence",
            sequenceName = "employ_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employ_sequence"
    )
    private Long employId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String jobName;

    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    private Integer age;

    @NotNull
    private LocalDate dob;

    @NotNull
    private LocalDate joiningDating;

    @NotNull
    private Integer experienceYears;

    public Employ() {
    }

    @ManyToOne
    private Department department;

    public Employ(String firstName, String lastName, String jobName,
                  String email, LocalDate dob, LocalDate joiningDating) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobName = jobName;
        this.email = email;
        this.dob = dob;
        this.joiningDating = joiningDating;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getEmployId() {
        return employId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getJoiningDating() {
        return joiningDating;
    }

    public void setJoiningDating(LocalDate joiningDating) {
        this.joiningDating = joiningDating;
    }

    public Integer getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(Integer experienceYears) {
        this.experienceYears = experienceYears;
    }

    public String getJobName() {
        return jobName;
    }

    /*public void addEmployToDepartment(){
        this.department.addEmployToDepartment();
    }*/

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public String toString() {
        return "Employ{" +
                "employId=" + employId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                ", joiningDating=" + joiningDating +
                ", experienceYears=" + experienceYears +
                '}';
    }
}
