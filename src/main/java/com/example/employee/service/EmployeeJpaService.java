package com.example.employee.service;

import com.example.employee.repository.EmployeeRepository;

import org.hibernate.internal.ExceptionConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.employee.repository.EmployeeJpaRepository;
import com.example.employee.model.Employee;



@Service
public class EmployeeJpaService implements EmployeeRepository{

    @Autowired
    private EmployeeJpaRepository employeeRepository;

    @Override
    public ArrayList<Employee> getAllEmployees(){
        List<Employee> employeeList= employeeRepository.findAll();
        return new ArrayList<>(employeeList);
    }


    @Override 
    public Employee getEmployeeById(int employeeId){
        try{
            Employee employee = employeeRepository.findById(employeeId).get();
            return employee;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public Employee addEmployee(Employee employee){
        try{
            employeeRepository.save(employee);
            return employee;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }


    @Override 
    public Employee updateEmployee(int employeeId,Employee employee){
        try{
            Employee existingEmployee = employeeRepository.findById(employeeId).get();
            if(employee.getEmployeeName()!=null){
                existingEmployee.setEmployeeName(employee.getEmployeeName());
            }
            if(employee.getEmail()!=null){
                existingEmployee.setEmail(employee.getEmail());
            }
            if(employee.getDepartment()!=null){
                existingEmployee.setDepartment(employee.getDepartment());
            }
            employeeRepository.save(existingEmployee);
            return existingEmployee;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override 
    public void deleteEmployee(int employeeId){
        try{
            employeeRepository.deleteById(employeeId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}