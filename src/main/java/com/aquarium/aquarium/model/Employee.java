package com.aquarium.aquarium.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private String birthdate;
    private String ssnumber;
    private String login;
    private String password;
    private boolean manager;

    @ManyToMany(
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value={"persons","baths"})
    private Set<Sector> sectors;

    /*@OneToMany(mappedBy = "resp",
            //fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties({"resp.sectors.employees", "resp.plannings.employees","sector.employees","sector.baths","plannings.employees","animals"})
    private Set<Bath> baths;*/

    /*@ManyToMany(mappedBy = "employees",
            fetch=FetchType.LAZY,
            cascade = CascadeType.MERGE)
    @JsonIgnoreProperties(value={"employees","bath.sector","bath.resp"})
    private Set<Planning> plannings;*/

    Employee(){}

    public Employee(String lastname, String firstname, String address, String birthdate, String ssnumber, Set<Sector>sectors, String login, String password, boolean manager) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
        this.birthdate = birthdate;
        this.ssnumber = ssnumber;
        this.sectors=sectors;
        this.login=login;
        this.password=password;
        this.manager=manager;
        //this.baths=new HashSet<Bath>();
        //this.plannings=new HashSet<Planning>();
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSsnumber() {
        return ssnumber;
    }

    public void setSsnumber(String ssnumber) {
        this.ssnumber = ssnumber;
    }

    /*public Set<Bath> getBaths() {
        return baths;
    }

    public void setBaths(Set<Bath> baths) {
        this.baths = baths;
    }*/

    public Set<Sector> getSectors() {
        return sectors;
    }

    public void setSectors(Set<Sector> sectors) {
        this.sectors = sectors;
    }

    /*public Set<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(Set<Planning> plannings) {
        this.plannings = plannings;
    }*/

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isManager() {
        return manager;
    }

    public void setManager(boolean manager) {
        this.manager = manager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){this.id=id;}
}
