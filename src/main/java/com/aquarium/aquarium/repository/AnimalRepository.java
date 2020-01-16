package com.aquarium.aquarium.repository;

import com.aquarium.aquarium.model.Animal;
import org.springframework.data.repository.CrudRepository;

public interface AnimalRepository extends CrudRepository <Animal, Long>{ }
