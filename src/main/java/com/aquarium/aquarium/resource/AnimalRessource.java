package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Animal;
import com.aquarium.aquarium.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnimalRessource {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/animals")
    public Iterable<Animal> getAnimals(){
        return animalService.getAll();
    }

    @GetMapping("/animals/{id}")
    public Animal getAnimal(@PathVariable Long id){
        return animalService.getOne(id);
    }

    @PostMapping("/animals")
    public Animal postAnimal(@RequestBody Animal animal){
        animalService.createAnimal(animal);
        return animal;
    }

    @DeleteMapping("/animals/{id}")
    public void deleteAnimal(@PathVariable Long id){
        animalService.deleteAnimal(id);
    }

    @PutMapping("/animals/{id}")
    public Animal updateAnimal(@PathVariable Long id, @RequestBody Animal animal){
        return animalService.updateAnimal(id, animal);
    }

}
