package com.BridgeLabz.EmployeePayRollApp.model;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false) // Prevents NULL values
    private String name;

    @Column(nullable = false)
    private double salary;

    @Column(nullable = false)
    private String gender;

    @JsonFormat(pattern = "dd MMM yyyy") // Ensures correct date format
    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private String note;

    @Column(nullable = false)
    private String profilePic;

    @ElementCollection(fetch = FetchType.EAGER) // Loads department list immediately
    @CollectionTable(name = "employee_departments", joinColumns = @JoinColumn(name = "employee_id"))
    private List<String> department;

    // Constructor to convert DTO to Entity
    public EmployeePayrollData(EmployeePayrollDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.startDate = employeeDTO.getStartDate();
        this.note = employeeDTO.getNote();
        this.profilePic = employeeDTO.getProfilePic();
        this.department = employeeDTO.getDepartment();
    }
}
