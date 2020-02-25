package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Planning;
import com.aquarium.aquarium.service.PlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanningRessource {

    @Autowired
    private PlanningService planningService;

    @GetMapping("/plannings")
    public Iterable<Planning> getPlanning(){
        return planningService.getAll();
    }

    @GetMapping("/plannings/{id}")
    public Planning getPlanning(@PathVariable Long id){
        return planningService.getOne(id);
    }

    @PostMapping("/plannings")
    public Planning postPlanning(@RequestBody Planning planning){
        planningService.createPlanning(planning);
        return planning;
    }

    @DeleteMapping("/plannings/{id}")
    public void deletePlanning(@PathVariable Long id){
        planningService.deletePlanning(id);
    }

    @PutMapping("/plannings/{id}")
    public Planning updatePlanning(@PathVariable Long id, @RequestBody Planning planning){
        return planningService.updatePlanning(id, planning);
    }
    
}
