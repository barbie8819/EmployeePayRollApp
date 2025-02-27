package com.BridgeLabz.EmployeePayRollApp.controller;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeeService;

    @GetMapping
    public List<EmployeePayrollDTO> getAllEmployees() {
        log.info("Fetching all employees");
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeePayrollDTO addEmployee(@Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO);
        return employeeService.addEmployee(employeeDTO);
    }
    @GetMapping("/{id}")
    public EmployeePayrollDTO getEmployeeById(@PathVariable int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeePayrollDTO updateEmployee(@PathVariable int id, @Valid @RequestBody EmployeePayrollDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        return employeeService.updateEmployee(id, employeeDTO);
    }
}
