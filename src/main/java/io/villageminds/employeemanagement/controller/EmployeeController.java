package io.villageminds.employeemanagement.controller;

import io.villageminds.employeemanagement.domain.Employee;
import io.villageminds.employeemanagement.persistence.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController implements ErrorController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable("id") Long id){
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("employee not found"));
    }

    @PostMapping("/employee")
    public String createEmployee(@RequestBody Employee employee){
        Employee emp = employeeRepository.save(employee);
        return  emp.getFirstName() + " saved to DB";
    }

    @PutMapping("/employee")
    public String updateEmployee(@RequestBody Employee employee){
        Employee emp = employeeRepository.save(employee);
        return emp.getFirstName() + " updated and saved to DB";
    }

    @DeleteMapping("/employee/{id}")
    public void deleteById(@PathVariable("id") Long id){
        employeeRepository.deleteById(id);
    }
}
