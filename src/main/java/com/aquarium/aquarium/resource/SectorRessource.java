package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.SectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SectorRessource {

    @Autowired
    private SectorService sectorService;

    @GetMapping("/sectors")
    public Iterable<Sector> getSector(){
        return sectorService.getAll();
    }

    @GetMapping("/sectors/{id}")
    public Sector getSector(@PathVariable Long id){
        return sectorService.getOne(id);
    }

    @PostMapping("/sectors")
    public Sector postSector(@RequestBody Sector sector){
        sectorService.createSector(sector);
        return sector;
    }

    @DeleteMapping("/sectors/{id}")
    public void deleteSector(@PathVariable Long id){
        sectorService.deleteSector(id);
    }

    @PutMapping("/sectors/{id}")
    public Sector updateSector(@PathVariable Long id, @RequestBody Sector sector){
        return sectorService.updateSector(id, sector);
    }
    
}
