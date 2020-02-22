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

    private String nom;
    private Sex sex;
    private String distinction;
    private Date arrival;
    private Date departure;

    @ManyToOne(//fetch=FetchType.LAZY,
            cascade=CascadeType.MERGE)
    @JsonIgnoreProperties("animals")
    private Species species;

    @ManyToOne(//fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties("animals")
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

    public Animal(String nom, Sex sex, String distinction, Date arrival, Species species, Bath bath){
        this.nom=nom;
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
                id, nom, sex.toString(), distinction, arrival.toString());
    }

    public void setId(Long ids){this.id=ids;}

    public Long getId(){
        return this.id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) { this.arrival = arrival; }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) { this.departure = departure; }

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
