package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRessource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public Iterable<Employee> getEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getOne(id);
    }

    @PostMapping("/employee")
    public Employee postEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employee/{id}")
    public Employee deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
    
}
