package com.BridgeLabz.EmployeePayRollApp.service;


import com.BridgeLabz.EmployeePayRollApp.dto.EmployeePayrollDTO;

import java.util.List;

public interface IEmployeePayrollService {
    List<EmployeePayrollDTO> getAllEmployees();
    EmployeePayrollDTO getEmployeeById(int id);
    EmployeePayrollDTO addEmployee(EmployeePayrollDTO employeeDTO);
    EmployeePayrollDTO updateEmployee(int id, EmployeePayrollDTO employeeDTO);
    List<EmployeePayrollDTO> getEmployeesBySalesDepartment();

}
