package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectorRessource {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sector")
    public Iterable<Sector> getSector(){
        return sectorService.getAll();
    }

    @GetMapping("/sector/{id}")
    public Sector getSector(@PathVariable Long id){
        return sectorService.getOne(id);
    }

    @PostMapping("/sector")
    public Sector postSector(@RequestBody Sector sector){
        sectorService.createSector(sector);
        return sector;
    }

    @DeleteMapping("/sector/{id}")
    public Sector deleteSector(@PathVariable Long id){
        return sectorService.deleteSector(id);
    }

    @PutMapping("/sector/{id}")
    public Sector updateSector(@PathVariable Long id, @RequestBody Sector sector){
        return sectorService.updateSector(id, sector);
    }
    
}
