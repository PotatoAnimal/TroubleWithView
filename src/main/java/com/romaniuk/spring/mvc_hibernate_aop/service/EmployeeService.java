package com.romaniuk.spring.mvc_hibernate_aop.service;

import com.romaniuk.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAllEmployees();
    public void saveEmployee (Employee employee);
}