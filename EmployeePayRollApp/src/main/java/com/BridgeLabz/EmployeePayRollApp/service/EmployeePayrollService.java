package com.BridgeLabz.EmployeePayRollApp.service;
import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import com.BridgeLabz.EmployeePayRollApp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    @Override
    public List<EmployeePayrollDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeePayrollDTO(emp.getName(), emp.getSalary()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeePayrollDTO getEmployeeById(int id) {
        EmployeePayrollData emp = employeeRepository.findById(id).orElse(null);
        return (emp != null) ? new EmployeePayrollDTO(emp.getName(), emp.getSalary()) : null;
    }

    @Override
    public EmployeePayrollDTO addEmployee(EmployeePayrollDTO employeeDTO) {
        EmployeePayrollData employee = new EmployeePayrollData(employeeDTO);
        EmployeePayrollData savedEmployee = employeeRepository.save(employee);
        return new EmployeePayrollDTO(savedEmployee.getName(), savedEmployee.getSalary());
    }

}