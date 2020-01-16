package com.aquarium.aquarium.model;

import org.apache.tomcat.jni.Time;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


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

    public enum Sex{
        Male,
        Female
    }

    public Animal(){}

    public Animal(String nom, Sex sex, String distinction, Date arrival){
        this.nom=nom;
        this.sex=sex;
        this.distinction=distinction;
        this.arrival=arrival;
    }

    public Animal(String nom, Sex sex, String distinction, Long id, Date arrival){
        this.nom=nom;
        this.sex=sex;
        this.distinction=distinction;
        this.id=id;
        this.arrival = arrival;

    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, name='%s', sex='%s', distinction='%s', date of arrival='%s']",
                id, nom, sex.toString(), distinction, arrival.toString());
    }

    public void setId(Long ids){
        this.id=ids;
    }

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

}
