package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Species {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private Long esperance;
    private Regime regime;
    private Integer endangered;

    @OneToMany(mappedBy = "species",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("species")
    private Set<Animal> animals;

    public enum Regime{
        Alguivore,
        Planctonivore,
        Piscivore
    }

    public Species(){}

    public Species(String name, Long esperance, Regime regime, Integer endangered){
        this.name=name;
        this.esperance=esperance;
        this.regime=regime;
        this.endangered=endangered;
    }

    @Override
    public String toString() {
        return String.format("Espece[id=%d, name='%s', esperance='%l', regime='%s', endangered='%i']",
                id, name, esperance, regime.toString(), endangered);
    }

    public void setId(Long ids){this.id=ids;}

    public Long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEsperance() {
        return esperance;
    }

    public void setEsperance(Long esperance) {
        this.esperance = esperance;
    }

    public Regime getRegime() {
        return regime;
    }

    public void setRegime(Regime regime) {
        this.regime = regime;
    }

    public void setEndangered(Integer endangered) {
        if(endangered>=0 && endangered<=10) {
            this.endangered = endangered;
        }
    }

    public Integer getEndangered() {
        return endangered;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }
}
