package com.romaniuk.spring.mvc_hibernate_aop.controller;

import com.romaniuk.spring.mvc_hibernate_aop.entity.Employee;
import com.romaniuk.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
@RequestMapping("/")
public class MyController {
    private final EmployeeService employeeService;

    public MyController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/mypn.png")
    public ResponseEntity<byte[]> getImage() throws IOException {
        // Load the image file from disk
        File imageFile = new File("src/main/webapp/WEB-INF/view/myPortfolioxD/mypn.png");
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());

        // Set the content type and return the image bytes in a ResponseEntity
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
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

    @GetMapping("/portfolio")
    public String toSeePortfolioPage(){
        return "myPortfolioxD/portfolioxD";
    }


}
