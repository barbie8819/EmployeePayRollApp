package com.BridgeLabz.EmployeePayRollApp.repository;
import com.BridgeLabz.EmployeePayRollApp.model.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {
}
