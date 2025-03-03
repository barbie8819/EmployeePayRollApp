package com.BridgeLabz.EmployeePayRollApp.controller;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    @Autowired
    private IEmployeePayrollService employeeService;

    @GetMapping
    public List<EmployeePayrollDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeePayrollDTO addEmployee(@RequestBody EmployeePayrollDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping("/{id}")
    public EmployeePayrollDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployeeById(id);
    }
}
