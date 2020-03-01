package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
public class Bath {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="bath_id")
    private Long id;
    private String name;
    private Long capacity;
    private Double volume;
    private State state;

    @ManyToOne(
            cascade={CascadeType.MERGE})
    @JsonIgnoreProperties(value={"persons","baths"})
    private Sector sector;

    @OneToMany(mappedBy = "bath",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value={"bath","species.animals"})
    private Set<Animal> animals;

    /*@OneToMany(mappedBy = "bath",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value={"bath"})
    private Set<Planning> plannings;*/

    /*@ManyToMany(
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("bath")
    private Set<Species> species;*/

    @ManyToOne(cascade={CascadeType.MERGE})//(
            //cascade= {CascadeType.MERGE})
    @JsonIgnoreProperties(value={"plannings,sectors"})
    private Employee resp;

    public enum State{
        dirty,
        clean
    }

    Bath(){}

    public Bath(String name, Long capacity, Double volume, State state, Sector sector, Employee resp/*, Set<Species> species*/) {
        this.name=name;
        this.capacity = capacity;
        this.volume = volume;
        this.state = state;
        this.sector = sector;
        //this.species=new HashSet<Species>();
        this.animals=new HashSet<Animal>();
        this.resp=resp;
        //this.plannings=new HashSet<Planning>();
        //this.species=species;
    }

    /*public Bath(Long capacity, Double volume, State state, Sector sector, HashSet<Animal> animals, Employee resp) {
        this.capacity = capacity;
        this.volume = volume;
        this.state = state;
        this.sector = sector;
        //this.species=species;
        this.animals=animals;
        this.resp=resp;
    }*/

    public void removeAnimal(Animal a){
        for(Animal an:animals){
            if(an.getId()==a.getId()){
                animals.remove(an);
            }
        }
    }

    public void addAnimal(Animal a){
        animals.add(a);
        //species.add(a.getSpecies());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public Set<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(Set<Animal> animals) {
        this.animals = animals;
    }

    public Employee getResp() {
        return resp;
    }

    public void setResp(Employee resp) {
        this.resp = resp;
    }

    /*public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
    }*/

    /*public Set<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Set<Planning> plannings) {
        this.plannings = plannings;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id=id;}

    @JsonProperty("sector_id")
    private void unpackNested(Long sector_id) {
        this.sector = new Sector();
        //sector.setId(sector_id);
    }
}
