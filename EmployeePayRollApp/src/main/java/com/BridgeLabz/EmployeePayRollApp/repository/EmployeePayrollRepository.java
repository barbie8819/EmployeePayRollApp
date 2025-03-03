package com.BridgeLabz.EmployeePayRollApp.repository;

import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

    // Custom Query to fetch employees belonging to "Sales" department
    @Query("SELECT e FROM EmployeePayrollData e WHERE 'Sales' MEMBER OF e.department")
    List<EmployeePayrollData> findEmployeesBySalesDepartment();
}
