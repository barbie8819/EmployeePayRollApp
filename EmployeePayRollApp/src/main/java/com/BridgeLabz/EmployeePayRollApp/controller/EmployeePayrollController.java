package com.BridgeLabz.EmployeePayRollApp.controller;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeePayrollController {

    private List<EmployeePayrollData> employeeList = new ArrayList<>();

    @GetMapping
    public List<EmployeePayrollData> getAllEmployees() {
        return employeeList;
    }

    @PostMapping
    public EmployeePayrollData addEmployee(@RequestBody EmployeePayrollData employee) {
        employee.setId(employeeList.size() + 1);
        employeeList.add(employee);
        return employee;
    }

    @GetMapping("/{id}")
    public EmployeePayrollData getEmployeeById(@PathVariable int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElse(null);
    }
}