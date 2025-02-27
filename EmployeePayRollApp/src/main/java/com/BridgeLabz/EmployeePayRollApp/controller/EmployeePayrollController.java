package com.BridgeLabz.EmployeePayRollApp.controller;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import lombok.extern.slf4j.Slf4j;


import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j  // Lombok annotation for logging
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeeService;

    @GetMapping
    public List<EmployeePayrollDTO> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeePayrollDTO addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO);
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping("/{id}")
    public EmployeePayrollDTO getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }
}