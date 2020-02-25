package com.aquarium.aquarium.service;

import com.aquarium.aquarium.model.Bath;
import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.repository.BathRepository;
import com.aquarium.aquarium.repository.SectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BathService {
    @Autowired
    private BathRepository bathRepository;

    /*@Autowired
    private SectorRepository sectorRepository;*/

    public Iterable<Bath> getAll(){
        return bathRepository.findAll();
    }

    public Bath getOne(Long id){
        return bathRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public Bath createBath(Bath b){
        //Sector s=sectorRepository.findById(b.getSector().getId()).get();
        bathRepository.save(b);
        return b;
    }

    public void deleteBath(Long id){
        bathRepository.deleteById(id);
    }

    public Bath updateBath(Long id, Bath bath){
        bathRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        bathRepository.save(bath);
        return bath;
    }
}
