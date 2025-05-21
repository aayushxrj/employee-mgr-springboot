package com.aayushxrj.employees.controller;

//import com.aayushxrj.employees.dao.EmployeeDAO;
import com.aayushxrj.employees.entity.Employee;
import com.aayushxrj.employees.request.EmployeeRequest;
import com.aayushxrj.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee REST API Endpoints", description = "Operations related to employees.")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees.")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Fetch single employee", description = "Get a single employee from database")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value=1) long employeeId) {
        Employee theEmployee = employeeService.findbyId(employeeId);
        return theEmployee;
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee to db.")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee) {

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @Operation(summary = "Update an employee", description = "Update the details of a current employee.")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value=1) long employeeId,
                                   @Valid @RequestBody EmployeeRequest employeeRequest) {

        Employee dbEmployee = employeeService.update(employeeId, employeeRequest);

        return dbEmployee;
    }

    @Operation(summary = "Delete a employee", description = "Remove an employee from the database.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value=1) long employeeId) {
        employeeService.deleteById(employeeId);
    }

}
