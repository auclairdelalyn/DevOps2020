package com.aquarium.aquarium.repository;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.model.Planning;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
