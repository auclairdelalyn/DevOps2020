package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Planning {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="planning_id")
    private Long id;

    private String name;
    private long hour;
    private long minutes;
    private Day day;

    @OneToOne(fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    //@JsonIgnoreProperties("planning")
    private Bath bath;

    public enum Day{
        everyday,
        monday,
        tuesday,
        wednesday,
        thursday,
        friday,
        saturday,
        sunday
    }

    public Planning(){}

    public Planning(String name, long hour, long minutes, Day day) {
        this.name = name;
        this.hour=hour;
        this.minutes=minutes;
        this.day=day;
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

    public long getHour() {
        return hour;
    }

    public long getMinutes() {
        return minutes;
    }

    public Day getDay() {
        return day;
    }

    public void setHour(long hour) {
        this.hour = hour;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    /*public void setBath(Bath bath) {
        this.bath = bath;
    }

    public Bath getBath() {
        return bath;
    }

    @JsonProperty("bath_id")
    private void unpackNested(Long bath_id) {
        this.bath = new Bath();
        bath.setId(bath_id);
    }*/
}
