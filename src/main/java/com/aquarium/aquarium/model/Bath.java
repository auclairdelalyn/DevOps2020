package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bath {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="bath_id")
    private Long id;
    private Long capacity;
    private Double volume;
    private State state;

    @OneToMany(fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    //@JsonIgnoreProperties("bath")
    private Set<Animal> animals;

    @OneToMany(fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    //@JsonIgnoreProperties("bath")
    private Set<Species> species;

    @ManyToOne(//fetch=FetchType.LAZY,
            cascade= {CascadeType.MERGE})
    @JsonIgnoreProperties("baths")
    private Sector sector;

    public enum State{
        dirty,
        clean
    }

    public Bath(){}

    public Bath(Long capacity, Double volume, State state, Sector sector) {
        this.capacity = capacity;
        this.volume = volume;
        this.state = state;
        this.sector = sector;
    }

    public void setId(Long ids){this.id=ids;}

    public Long getId(){
        return this.id;
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

    /*public Set<> getAnimals() {
        return animals;
    }*/

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector s) {
        this.sector=sector;
    }

    @JsonProperty("sector_id")
    private void unpackNested(Long sector_id) {
        this.sector = new Sector();
        sector.setId(sector_id);
    }
}
