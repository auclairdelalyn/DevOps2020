package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Planning;
import com.aquarium.aquarium.repository.PlanningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanningService {

    @Autowired
    private PlanningRepository planningRepository;

    public Iterable<Planning> getAll(){
        return planningRepository.findAll();
    }

    public Planning getOne(Long id){
        return planningRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Planning createPlanning(Planning s){
        planningRepository.save(s);
        return s;
    }

    public Planning deletePlanning(Long id){
        Planning s= planningRepository.findById(id).get();
        planningRepository.deleteById(id);
        return s;
    }

    public Planning updatePlanning(Long id, Planning planning){
        planningRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        //planning.setId(id);
        planningRepository.save(planning);
        return planning;
    }
    
}
