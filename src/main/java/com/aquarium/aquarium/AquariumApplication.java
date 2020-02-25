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
		Sector s=sectorService.createSector(new Sector("PLOP", "aaaaaaaaaaa"));
		ss.add(s);
		Employee e=employeeService.createEmployee(new Employee("aaaa","bbbb", "sdfdf", new Date(), "ss", true,ss));
		Employee e1=employeeService.createEmployee(new Employee("aaaa2","bbbb", "sdfdf", new Date(), "ss", true,ss));
		Species sp=speciesService.createSpecies(new Species("homo sapiens", 75L, Species.Regime.Piscivore, 2));
		Set<Species>spe=new HashSet<Species>();
		spe.add(sp);
		Set<Employee>empl=new HashSet<Employee>();
		empl.add(e);
		Bath b=bathService.createBath(new Bath(50L, 25.5, Bath.State.clean, s,e));
		Bath b1=bathService.createBath(new Bath(50L, 27.5, Bath.State.clean, s,e));
		Animal a=animalService.createAnimal(new Animal("moi", Animal.Sex.Male,"dev", new Date(), sp, b));
		Planning p=planningService.createPlanning(new Planning("faire caca", 15L, 20l, Planning.Day.everyday, true, empl, b));
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
