package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    //@Column(name="planning_id")
    private Long id;

    private String lastname;
    private String firstname;
    private String address;
    private Date birthDate;
    private String ssNumber;
    private boolean manager;

    @ManyToMany(
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"persons","baths"})
    private Set<Sector> sectors;

    @OneToMany(mappedBy = "resp",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"resp","sector","plannings","animals"})
    private Set<Bath> baths;

    @ManyToMany(mappedBy = "employees",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"employees","bath"})
    private Set<Planning> plannings;

    Employee(){}

    public Employee(String lastname, String firstname, String address, Date birthDate, String ssNumber, boolean manager, Set<Sector>sectors) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.birthDate = birthDate;
        this.ssNumber = ssNumber;
        this.manager=manager;
        this.sectors=sectors;
        this.baths=new HashSet<Bath>();
        this.plannings=new HashSet<Planning>();
    }

    /*public Employee(String lastname, String firstname, String address, Date birthDate, String ssNumber, boolean manager, HashSet<Sector> sectors) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.birthDate = birthDate;
        this.ssNumber = ssNumber;
        this.manager=manager;
        //this.sectors=sectors;
        this.baths=baths;
    }*/

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSsNumber() {
        return ssNumber;
    }

    public void setSsNumber(String ssNumber) {
        this.ssNumber = ssNumber;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public Set<Bath> getBaths() {
        return baths;
    }

    public void setBaths(Set<Bath> baths) {
        this.baths = baths;
    }

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    public Set<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Set<Planning> plannings) {
        this.plannings = plannings;
    }

    public Long getId() {
        return id;
    }
}
