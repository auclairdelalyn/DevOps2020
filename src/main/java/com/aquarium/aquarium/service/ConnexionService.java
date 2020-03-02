package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnexionService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployee(String login, String password) {
        Iterable<Employee> employees=employeeRepository.findAll();
        for(Employee p:employees){
            if(p.getLogin().equals(login) && p.getPassword().equals(password)){
                return Optional.of(p);
            }
        }
        return Optional.empty();//Optional.ofNullable(employeeRepository.findByLoginAngPassword(login, password).orElseThrow(NotFoundException::new));

    }
}
