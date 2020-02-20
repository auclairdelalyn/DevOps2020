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

    public Sector(){}

    public Sector(String name, String localisation) {
        this.name = name;
        this.localisation = localisation;
        this.baths=new HashSet<Bath>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
