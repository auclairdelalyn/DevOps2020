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
    //@Column(name="planning_id")
    private Long id;

    private String name;
    private long hour;
    private long minutes;
    private Day day;
    private boolean isPublic;

    @ManyToOne(
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"plannings","resp"})
    private Bath bath;

    @ManyToMany(
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"plannings","sectors","baths"})
    private Set<Employee> employees;

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

    Planning(){}

    public Planning(String name, long hour, long minutes, Day day, boolean isPublic, Set<Employee> employees, Bath bath) {
        this.name = name;
        this.hour=hour;
        this.minutes=minutes;
        this.day=day;
        this.isPublic=isPublic;
        this.employees=employees;
        this.bath=bath;
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

    public void setHour(long hour) {
        this.hour = hour;
    }

    public long getMinutes() {
        return minutes;
    }

    public void setMinutes(long minutes) {
        this.minutes = minutes;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Bath getBath() {
        return bath;
    }

    public void setBath(Bath bath) {
        this.bath = bath;
    }

    public Long getId() {
        return id;
    }
}
