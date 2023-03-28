package com.romaniuk.spring.mvc_hibernate_aop.controller;

import com.romaniuk.spring.mvc_hibernate_aop.entity.Employee;
import com.romaniuk.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/emp")
    public String showAllEmployees(Model model){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "employers/allEmployees";
    }

    @GetMapping("/addNewEmployee")
    public String addNewEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employers/addNewEmp";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.saveEmployee(employee);

        return "redirect:/emp";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") int id, Model model){
        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);
        return "employers/addNewEmp";
    }

    @RequestMapping("/deleteInfo")
    public String deleteEmployee(@RequestParam("empId") int id, Model model){
        employeeService.deleteEmployee(id);
        return "redirect:/emp";
    }
}
