package com.aayushxrj.employees.dao;

import com.aayushxrj.employees.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // that's it !
}
