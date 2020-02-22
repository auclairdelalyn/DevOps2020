package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Sector {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="sector_id")
    private Long id;

    private String name;
    private String localisation;

    @OneToMany(mappedBy = "sector",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("sector")
    private Set<Bath> baths;

    @ManyToMany(mappedBy = "sectors",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"sectors","baths"})
    private Set<Employee> persons;

    Sector(){}

    public Sector(String name, String localisation) {
        this.name = name;
        this.localisation = localisation;
        this.baths=new HashSet<Bath>();
        this.persons=new HashSet<Employee>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public Set<Bath> getBaths() {
        return baths;
    }

    public void setBaths(Set<Bath> baths) {
        this.baths = baths;
    }

    public Set<Employee> getPersons() {
        return persons;
    }

    public void setPersons(Set<Employee> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }
}
