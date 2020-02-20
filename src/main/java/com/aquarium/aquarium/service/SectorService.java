package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectorService {
    @Autowired
    private SectorRepository sectorRepository;

    public Iterable<Sector> getAll(){
        return sectorRepository.findAll();
    }

    public Sector getOne(Long id){
        return sectorRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Sector createSector(Sector s){
        sectorRepository.save(s);
        return s;
    }

    public Sector deleteSector(Long id){
        Sector s= sectorRepository.findById(id).get();
        sectorRepository.deleteById(id);
        return s;
    }

    public Sector updateSector(Long id, Sector sector){
        sectorRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        sector.setId(id);
        sectorRepository.save(sector);
        return sector;
    }
}
