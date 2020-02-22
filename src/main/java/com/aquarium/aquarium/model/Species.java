package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
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
    @JsonIgnoreProperties({"species","bath"})
    private Set<Animal> animals;

    /*@ManyToMany(mappedBy = "species",
            fetch=FetchType.LAZY,
            cascade= {CascadeType.MERGE})
    @JsonIgnoreProperties("species")
    private Set<Bath> baths;*/

    public enum Regime{
        Alguivore,
        Planctonivore,
        Piscivore
    }

    Species(){}

    public Species(String name, Long esperance, Regime regime, Integer endangered){
        this.name=name;
        this.esperance=esperance;
        this.regime=regime;
        this.endangered=endangered;
        this.animals=new HashSet<Animal>();
        //this.baths=new HashSet<Bath>();
    }

    public Species(String name, Long esperance, Regime regime, Integer endangered, Set<Animal> animals, Set<Bath> baths) {
        this.name = name;
        this.esperance = esperance;
        this.regime = regime;
        this.endangered = endangered;
        //this.animals = animals;
        //this.baths = baths;
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

    public Integer getEndangered() {
        return endangered;
    }

    public void setEndangered(Integer endangered) {
        this.endangered = endangered;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    /*public Set<Bath> getBaths() {
        return baths;
    }

    public void setBaths(Set<Bath> baths) {
        this.baths = baths;
    }*/

    public Long getId() {
        return id;
    }
}
