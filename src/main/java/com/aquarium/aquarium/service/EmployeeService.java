package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Iterable<Employee> getAll(){
        return employeeRepository.findAll();
    }

    public Employee getOne(Long id){
        return employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Employee createEmployee(Employee b){
        employeeRepository.save(b);
        return b;
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employee){
        employeeRepository.findById(id).orElseThrow(IllegalArgumentException::new);

        employeeRepository.save(employee);
        return employee;
    }
}
