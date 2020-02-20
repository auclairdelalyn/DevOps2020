package com.aquarium.aquarium.repository;

import com.aquarium.aquarium.model.Species;
import org.springframework.data.repository.CrudRepository;

public interface SpeciesRepository extends CrudRepository<Species, Long> { }