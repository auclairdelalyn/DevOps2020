package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Bath;
import com.aquarium.aquarium.service.BathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BathRessource {
    @Autowired
    private BathService bathService;

    @GetMapping("/baths")
    public Iterable<Bath> getBath(){
        return bathService.getAll();
    }

    @GetMapping("/baths/{id}")
    public Bath getBath(@PathVariable Long id){
        return bathService.getOne(id);
    }

    @PostMapping("/baths")
    public Bath postBath(@RequestBody Bath bath){
        bathService.createBath(bath);
        return bath;
    }

    @DeleteMapping("/baths/{id}")
    public void deleteBath(@PathVariable Long id){
        bathService.deleteBath(id);
    }

    @PutMapping("/baths/{id}")
    public Bath updateBath(@PathVariable Long id, @RequestBody Bath bath){
        return bathService.updateBath(id, bath);
    }
}
