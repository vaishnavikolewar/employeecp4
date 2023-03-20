package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;


import com.example.employee.service.EmployeeJpaService;
import com.example.employee.model.Employee;

@RestController
public class EmployeeController{

    @Autowired
    private EmployeeJpaService employeeService;

    @GetMapping("/employees")
    public ArrayList<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId, employee);
    }


    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeService.deleteEmployee(employeeId);
    }
}