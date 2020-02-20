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

    public Bath deleteBath(Long id){
        Bath b= bathRepository.findById(id).get();
        bathRepository.deleteById(id);
        return b;
    }

    public Bath updateBath(Long id, Bath bath){
        bathRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        bath.setId(id);
        bathRepository.save(bath);
        return bath;
    }
}
