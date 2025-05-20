package com.aayushxrj.employees.dao;

import com.aayushxrj.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}
