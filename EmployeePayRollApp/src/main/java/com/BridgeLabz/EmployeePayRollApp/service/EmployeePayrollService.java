package com.BridgeLabz.EmployeePayRollApp.service;

import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import com.BridgeLabz.EmployeePayRollApp.repository.EmployeePayrollRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    private EmployeePayrollRepository employeeRepository;

    @Override
    public List<EmployeePayrollDTO> getAllEmployees() {
        log.info("Fetching all employees from database");
        return employeeRepository.findAll().stream()
                .map(emp -> new EmployeePayrollDTO(emp.getName(), emp.getSalary(), emp.getGender(),
                        emp.getStartDate(), emp.getNote(), emp.getProfilePic(), emp.getDepartment()))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeePayrollDTO getEmployeeById(int id) {
        log.info("Fetching employee with ID: {}", id);
        return employeeRepository.findById(id)
                .map(emp -> new EmployeePayrollDTO(emp.getName(), emp.getSalary(), emp.getGender(),
                        emp.getStartDate(), emp.getNote(), emp.getProfilePic(), emp.getDepartment()))
                .orElseThrow(() -> {
                    log.error("Employee with ID {} not found", id);
                    return new RuntimeException("Employee with ID " + id + " not found");
                });
    }

    @Override
    public EmployeePayrollDTO addEmployee(@Valid EmployeePayrollDTO employeeDTO) {
        log.info("Adding new employee: {}", employeeDTO);
        EmployeePayrollData employee = new EmployeePayrollData(employeeDTO);
        EmployeePayrollData savedEmployee = employeeRepository.save(employee);
        log.info("Employee saved successfully with ID: {}", savedEmployee.getId());
        return new EmployeePayrollDTO(savedEmployee.getName(), savedEmployee.getSalary(),
                savedEmployee.getGender(), savedEmployee.getStartDate(), savedEmployee.getNote(),
                savedEmployee.getProfilePic(), savedEmployee.getDepartment());
    }

    @Override
    public EmployeePayrollDTO updateEmployee(int id, @Valid EmployeePayrollDTO employeeDTO) {
        log.info("Updating employee with ID: {}", id);
        EmployeePayrollData employee = employeeRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Employee with ID {} not found", id);
                    return new RuntimeException("Employee not found");
                });

        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employee.setGender(employeeDTO.getGender());
        employee.setStartDate(employeeDTO.getStartDate());
        employee.setNote(employeeDTO.getNote());
        employee.setProfilePic(employeeDTO.getProfilePic());
        employee.setDepartment(employeeDTO.getDepartment());

        EmployeePayrollData updatedEmployee = employeeRepository.save(employee);
        log.info("Employee updated successfully with ID: {}", updatedEmployee.getId());
        return new EmployeePayrollDTO(updatedEmployee.getName(), updatedEmployee.getSalary(),
                updatedEmployee.getGender(), updatedEmployee.getStartDate(), updatedEmployee.getNote(),
                updatedEmployee.getProfilePic(), updatedEmployee.getDepartment());
    }
}
