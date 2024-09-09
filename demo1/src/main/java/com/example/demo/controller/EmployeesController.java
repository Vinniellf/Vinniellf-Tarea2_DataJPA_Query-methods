package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.entity.Job;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.JobRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeesController {

    final EmployeeRepo employeesRepository;
    final JobRepo employeesJobRepository;

    public EmployeesController(EmployeeRepo employeesRepository, JobRepo employeesJobRepository) {
        this.employeesRepository = employeesRepository;
        this.employeesJobRepository = employeesJobRepository;

    }


    @GetMapping("/list")
    public String listarEmpleados(Model model) {
        List<Employee> listaEmployees = employeesRepository.findAll();
        model.addAttribute("listaEmployees", listaEmployees);
        return "ListarEmployee";
    }

    @GetMapping("/info/{id}")
    public String informEmpleado(Model model, @PathVariable int id) {
        List<Job> listJob = employeesJobRepository.findAll();
        model.addAttribute("listJob", listJob);
        Optional<Employee> employeeOptional = employeesRepository.findById(id);
        if(employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            model.addAttribute("employee", employee);
            return "infoEmployee";
        }else{
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String borrarEmpleado(Model model, @PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            employeesRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("msg", "Se borró el empleado");
            redirectAttributes.addFlashAttribute("alert", "alert-success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msg", "No se pudo borrar el empleado");
            redirectAttributes.addFlashAttribute("alert", "alert-danger");
        }
        return "redirect:/employee/list";
    }





}
