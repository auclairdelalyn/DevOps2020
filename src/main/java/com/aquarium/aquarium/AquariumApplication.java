package com.aquarium.aquarium;

import com.aquarium.aquarium.model.*;
import com.aquarium.aquarium.resource.PlanningRessource;
import com.aquarium.aquarium.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.*;

@SpringBootApplication
public class AquariumApplication implements CommandLineRunner {
	@Autowired
	private SectorService sectorService;
	@Autowired
	private BathService bathService;
	@Autowired
	private SpeciesService speciesService;
	@Autowired
	private AnimalService animalService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private PlanningService planningService;

	public static void main(String[] args) {
		SpringApplication.run(AquariumApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*
		Set<Sector>ss1=new HashSet<Sector>();
		Set<Sector>ss2=new HashSet<Sector>();
		Set<Sector>ss3=new HashSet<Sector>();
		Set<Sector>ss4=new HashSet<Sector>();
		Sector sN=sectorService.createSector(new Sector("Secteur Nord", "Nord"));
		Sector sO=sectorService.createSector(new Sector("Secteur Ouest", "Ouest"));
		Sector sE=sectorService.createSector(new Sector("Secteur Est", "Est"));
		Sector sS=sectorService.createSector(new Sector("Secteur Sud", "Sud"));
		ss1.add(sN);
		ss1.add(sE);
		ss2.add(sN);
		ss2.add(sO);
		ss3.add(sS);
		ss3.add(sE);
		ss4.add(sS);
		ss4.add(sO);
		Employee e1=employeeService.createEmployee(new Employee("Smith","John", "15 Avenue de la République, Paris", "13-11-1991", "X XX XX XX XXX XXX XX",ss1, "J0HN", "5M1TH", true));
		Employee e2=employeeService.createEmployee(new Employee("Nicholson","Jack", "70 Rue André Malraux, Montreuil", "05-12-1956", "X XX XX XX XXX XXX XX",ss2, "J4CK", "N1CH0L50N", false));
		Employee e3=employeeService.createEmployee(new Employee("Ripley","Ellen", "5 Place Monge, Paris", "24-05-1941", "X XX XX XX XXX XXX XX",ss3, "3LL3N", "R1PL3Y", false));
		Employee e4=employeeService.createEmployee(new Employee("Naruto","Uzumaki", "10 Rue de la Boetie, Paris", "15-01-2000", "X XX XX XX XXX XXX XX",ss4, "N4RUT0", "UZUM4K1", true));
		Species sp1=speciesService.createSpecies(new Species("Jellyfish", 2L, Species.Regime.Planctonivore, 2));
		Species sp2=speciesService.createSpecies(new Species("Sharks", 25L, Species.Regime.Piscivore, 7));
		Species sp3=speciesService.createSpecies(new Species("Octopus", 15L, Species.Regime.Piscivore, 0));
		//spe.add(sp);
		Set<Employee>ee1=new HashSet<Employee>();
		Set<Employee>ee2=new HashSet<Employee>();
		Set<Employee>ee3=new HashSet<Employee>();
		Set<Employee>ee4=new HashSet<Employee>();
		ee1.add(e1);
		ee2.add(e1);
		ee2.add(e2);
		ee3.add(e3);
		ee4.add(e3);

		Bath bN1=bathService.createBath(new Bath("N1", 50L, 25.5, Bath.State.clean, sN,e1));
		Bath bN2=bathService.createBath(new Bath("N2", 50L, 27.5, Bath.State.clean, sN,e1));
		Bath bN3=bathService.createBath(new Bath("N3", 50L, 27.5, Bath.State.clean, sN,e1));
		Bath bN4=bathService.createBath(new Bath("N4", 50L, 25.5, Bath.State.clean, sN,e1));
		Bath bO1=bathService.createBath(new Bath("O1", 50L, 27.5, Bath.State.clean, sO,e2));
		Bath bO2=bathService.createBath(new Bath("O2", 50L, 27.5, Bath.State.clean, sO,e2));
		Bath bO3=bathService.createBath(new Bath("O3", 50L, 25.5, Bath.State.clean, sO,e2));
		Bath bO4=bathService.createBath(new Bath("O4", 50L, 27.5, Bath.State.clean, sO,e2));
		Bath bE1=bathService.createBath(new Bath("E1", 50L, 27.5, Bath.State.clean, sE,e3));
		Bath bE2=bathService.createBath(new Bath("E2", 50L, 25.5, Bath.State.clean, sE,e3));
		Bath bE3=bathService.createBath(new Bath("E3", 50L, 27.5, Bath.State.clean, sE,e3));
		Bath bE4=bathService.createBath(new Bath("E4", 50L, 27.5, Bath.State.clean, sE,e3));
		Bath bS1=bathService.createBath(new Bath("S1", 50L, 27.5, Bath.State.clean, sS,e4));
		Bath bS2=bathService.createBath(new Bath("S2", 50L, 25.5, Bath.State.clean, sS,e4));
		Bath bS3=bathService.createBath(new Bath("S3", 50L, 27.5, Bath.State.clean, sS,e4));
		Bath bS4=bathService.createBath(new Bath("S4", 50L, 27.5, Bath.State.clean, sS,e4));
		Animal a1=animalService.createAnimal(new Animal("Cubozoa", Animal.Sex.Male,"Cubomeduse", "2019-10-15", sp1, bN1));
		Animal a2=animalService.createAnimal(new Animal("Hydrozoa", Animal.Sex.Male,"Hydromeduse", "2019-10-15", sp1, bN2));
		Animal a3=animalService.createAnimal(new Animal("HammerHead", Animal.Sex.Male,"Requin Marteau", "2019-10-15", sp2, bO1));
		Animal a4=animalService.createAnimal(new Animal("Greate White", Animal.Sex.Male,"Requin Blanc", "2019-10-15", sp2, bE2));
		Animal a5=animalService.createAnimal(new Animal("Giant Squid", Animal.Sex.Male,"Squid", "2019-10-15", sp3, bS1));
		Animal a6=animalService.createAnimal(new Animal("Octopus", Animal.Sex.Male,"Intelligent", "2019-10-15", sp3, bE2));
		Planning p=planningService.createPlanning(new Planning("Feed Sharks", 15L, 30l, Planning.Day.everyday, false, ee2, bO1));
		Planning p1=planningService.createPlanning(new Planning("Play with Octopus", 10L, 00l, Planning.Day.sunday, true, ee3, bE2));
	*/
	}

}
