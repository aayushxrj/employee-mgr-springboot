package com.aayushxrj.employees.service;

import com.aayushxrj.employees.entity.Employee;
import com.aayushxrj.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findbyId(long theId);

    Employee save(EmployeeRequest theEmployeeRequest);

    Employee update(long id, EmployeeRequest employeeRequest);

    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);

    void deleteById(long theId);
}
