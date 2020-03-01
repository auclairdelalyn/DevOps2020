package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.tomcat.jni.Time;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private Sex sex;
    private String distinction;
    private String arrival;
    private String departure;

    @ManyToOne//(
            //cascade=CascadeType.MERGE)
    @JsonIgnoreProperties(value={"animals"})
    private Species species;

    @ManyToOne//(
            //cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value={"animals","plannings","resp.sector"})
    private Bath bath;

    public enum Sex{
        Male,
        Female
    }

    Animal(){}

    /*public Animal(String nom, Sex sex, String distinction, Date arrival, Species species){
        this.nom=nom;
        this.sex=sex;
        this.distinction=distinction;
        this.arrival=arrival;
        this.species=species;
        this.bath=null;
    }*/

    public Animal(String name, Sex sex, String distinction, String arrival, Species species, Bath bath){
        this.name=name;
        this.sex=sex;
        this.distinction=distinction;
        this.arrival=arrival;
        this.species=species;
        this.bath=bath;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', sex='%s', distinction='%s', date of arrival='%s']",
                id, name, sex.toString(), distinction, arrival.toString());
    }

    public void setId(Long id){this.id=id;}

    public Long getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() { return sex; }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getDistinction() {
        return distinction;
    }

    public void setDistinction(String distinction) {
        this.distinction = distinction;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) { this.arrival = arrival; }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) { this.departure = departure; }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @JsonProperty("species_id")
    private void unpackNestedsp(Long species_id) {
        this.species = new Species();
        //species.setId(species_id);
    }

    @JsonProperty("bath_id")
    private void unpackNestedba(Long bath_id) {
        this.bath = new Bath();
        //bath.setId(bath_id);
    }

    public Bath getBath() {
        return bath;
    }

    public void setBath(Bath bath) {
        this.bath = bath;
    }
}
