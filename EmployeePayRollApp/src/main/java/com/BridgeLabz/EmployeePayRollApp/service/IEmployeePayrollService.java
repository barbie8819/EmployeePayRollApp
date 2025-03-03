package com.BridgeLabz.EmployeePayRollApp.service;
import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollDTO> getAllEmployees();
    EmployeePayrollDTO getEmployeeById(int id);
    EmployeePayrollDTO addEmployee(EmployeePayrollDTO employeeDTO);
}