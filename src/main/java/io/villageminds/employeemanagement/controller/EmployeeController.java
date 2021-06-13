package io.villageminds.employeemanagement.controller;

import io.villageminds.employeemanagement.domain.Employee;
import io.villageminds.employeemanagement.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController implements ErrorController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeRepository.findById(id);
    }
}
