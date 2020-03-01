package com.aquarium.aquarium;

import com.aquarium.aquarium.model.*;
import com.aquarium.aquarium.resource.PlanningRessource;
import com.aquarium.aquarium.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
		Set<Sector>ss=new HashSet<Sector>();
		Set<Sector>ss2=new HashSet<Sector>();
		Sector s=sectorService.createSector(new Sector("PLOP", "aaaaaaaaaaa"));
		Sector s1=sectorService.createSector(new Sector("PLOP2", "aaaaaaaaaaa"));
		ss.add(s);
		ss2.add(s1);
		Employee e=employeeService.createEmployee(new Employee("aaaa","bbbb", "sdfdf", "13-11-1991", "ss",ss));
		Employee e1=employeeService.createEmployee(new Employee("aaaa2","bbbb", "sdfdf", "05-12-1956", "ss",ss));
		Employee e2=employeeService.createEmployee(new Employee("aaaa2","bbbb", "sdfdf", "24-05-1941", "ss",ss2));
		Species sp=speciesService.createSpecies(new Species("homo sapiens", 75L, Species.Regime.Piscivore, 2));
		Set<Species>spe=new HashSet<Species>();
		spe.add(sp);
		Set<Employee>empl=new HashSet<Employee>();
		empl.add(e);
		Bath b=bathService.createBath(new Bath("B1", 50L, 25.5, Bath.State.clean, s,e));
		Bath b1=bathService.createBath(new Bath("B2", 50L, 27.5, Bath.State.clean, s,e));
		Bath b2=bathService.createBath(new Bath("B3", 50L, 27.5, Bath.State.clean, s1,e2));
		Animal a=animalService.createAnimal(new Animal("moi", Animal.Sex.Male,"dev", "2019-10-15", sp, b));
		Planning p=planningService.createPlanning(new Planning("faire caca", 15L, 20l, Planning.Day.everyday, true, empl, b));
		Planning p1=planningService.createPlanning(new Planning("faire pipi", 15L, 20l, Planning.Day.everyday, false, empl, b));
		//b=bathService.createBath(b);
		/*s.addBath(b);
		Employee e=employeeService.createEmployee(new Employee("aaaa","bbbb", "sdfdf", new Date(), "ss", true));
		s.addEmployee(e);
		b.setResp(e);

		a.setBath(b);
		a=animalService.createAnimal(a);
		b=bathService.createBath(b);
		//s=sectorService.createSector(s);
		//Planning p=planningService.createPlanning(new Planning("faire caca", 15L, 20l, Planning.Day.everyday, true, new HashSet<Employee>((Collection<? extends Employee>) employeeService.getAll())));
	*/}

}
