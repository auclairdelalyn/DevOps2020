package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRessource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public Iterable<Employee> getEmployee(){
        return employeeService.getAll();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getOne(id);
    }

    @PostMapping("/employees")
    public Employee postEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
    
}
