package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Species;
import com.aquarium.aquarium.model.Species;
import com.aquarium.aquarium.service.SpeciesService;
import com.aquarium.aquarium.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpeciesRessource {
    @Autowired
    private SpeciesService speciesService;

    @GetMapping("/species")
    public Iterable<Species> getSpecies(){
        return speciesService.getAll();
    }

    @GetMapping("/species/{id}")
    public Species getSpecies(@PathVariable Long id){
        return speciesService.getOne(id);
    }

    @PostMapping("/species")
    public Species postSpecies(@RequestBody Species species){
        speciesService.createSpecies(species);
        return species;
    }

    @DeleteMapping("/species/{id}")
    public Species deleteSpecies(@PathVariable Long id){
        return speciesService.deleteSpecies(id);
    }

    @PutMapping("/species/{id}")
    public Species updateSpecies(@PathVariable Long id, @RequestBody Species species){
        return speciesService.updateSpecies(id, species);
    }
}
