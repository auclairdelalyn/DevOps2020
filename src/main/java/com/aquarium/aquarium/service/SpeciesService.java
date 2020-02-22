package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Animal;
import com.aquarium.aquarium.model.Species;
import com.aquarium.aquarium.repository.AnimalRepository;
import com.aquarium.aquarium.repository.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpeciesService {
    @Autowired
    private SpeciesRepository speciesRepository;

    public Iterable<Species> getAll(){
        return speciesRepository.findAll();
    }

    public Species getOne(Long id){
        return speciesRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Species createSpecies(Species s){
        speciesRepository.save(s);
        return s;
    }

    public Species deleteSpecies(Long id){
        Species s= speciesRepository.findById(id).get();
        speciesRepository.deleteById(id);
        return s;
    }

    public Species updateSpecies(Long id, Species species){
        speciesRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        //species.setId(id);
        speciesRepository.save(species);
        return species;
    }
}
