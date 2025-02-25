package com.BridgeLabz.EmployeePayRollApp.model;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class EmployeePayrollData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;

    public EmployeePayrollData() {}

    public EmployeePayrollData(EmployeePayrollDTO employeeDTO) {
        this.name = employeeDTO.name;
        this.salary = employeeDTO.salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getSalary() { return salary; }

    public void setName(String name) { this.name = name; }
    public void setSalary(double salary) { this.salary = salary; }
}
