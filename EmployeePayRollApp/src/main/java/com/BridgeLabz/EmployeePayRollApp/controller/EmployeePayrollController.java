package com.BridgeLabz.EmployeePayRollApp.controller;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import com.BridgeLabz.EmployeePayRollApp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    @GetMapping
    public List<EmployeePayrollDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeePayrollDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    @PostMapping
    public EmployeePayrollDTO addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData(employeeDTO);
        employeeRepository.save(employee);
        return employeeDTO;
    }

    @GetMapping("/{id}")
    public EmployeePayrollDTO getEmployeeById(@PathVariable int id) {
        EmployeePayrollData emp = employeeRepository.findById(id).orElse(null);
        return (emp != null) ? new EmployeePayrollDTO(emp.getName(), emp.getSalary()) : null;
    }
}
