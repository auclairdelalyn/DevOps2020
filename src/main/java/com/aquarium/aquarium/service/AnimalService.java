package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Animal;
import com.aquarium.aquarium.model.Species;
import com.aquarium.aquarium.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Iterable<Animal> getAll(){
        return animalRepository.findAll();
    }

    public Animal getOne(Long id){
        return animalRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Animal createAnimal(Animal a){
        animalRepository.save(a);
        return a;
    }

    public void deleteAnimal(Long id){
        animalRepository.deleteById(id);
    }

    public Animal updateAnimal(Long id, Animal animal){
        animalRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        animal.setId(id);
        animalRepository.save(animal);
        return animal;
    }
}
