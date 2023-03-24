package com.romaniuk.spring.mvc_hibernate_aop.controller;

import com.romaniuk.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.romaniuk.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {

    private final EmployeeDAO employeeDAO;

    public MyController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GetMapping("/emp")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeDAO.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "allEmployees";
    }
}
