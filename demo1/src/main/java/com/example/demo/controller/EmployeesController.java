package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.JobRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeesController {

    final EmployeeRepo employeesRepository;
    final JobRepo employeesJobRepository;

    public EmployeesController(EmployeeRepo employeesRepository, JobRepo employeesJobRepository) {
        this.employeesRepository = employeesRepository;
        this.employeesJobRepository = employeesJobRepository;
    }


    @GetMapping("/listar")
    public String showEmployees(Model model) {
        List<Employee> listaEmployees = employeesRepository.findAll();
        model.addAttribute("listaEmployees", listaEmployees);
        return "ListarEmployee";
    }





}
