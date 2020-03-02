package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.*;
import com.aquarium.aquarium.service.AnimalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestAnimal {

    @MockBean
    private AnimalService animalService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Animal> P = new ArrayList<Animal>();
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Bath b=new Bath("test", 0L, 0.0, Bath.State.clean, s,e);
        Species sp=new Species("test", 0L, Species.Regime.Piscivore, 10);
        P.add(new Animal("test1", Animal.Sex.Male,"test", "test", sp, b));
        P.add(new Animal("test2", Animal.Sex.Male,"test", "test", sp, b));
        P.add(new Animal("test3", Animal.Sex.Male,"test", "test", sp, b));
        Animal p = P.get(0);
        Mockito.when(animalService.getAll()).thenReturn(P);
        List<Animal> animals = this.restTemplate.getForObject("http://localhost:" + port + "/animals",
                List.class);
        assertEquals(3, animals.size());
    }

    @Test
    public void create() {
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Bath b=new Bath("test", 0L, 0.0, Bath.State.clean, s,e);
        Species sp=new Species("test", 0L, Species.Regime.Piscivore, 10);
        Animal a=new Animal("test", Animal.Sex.Male,"test", "test", sp, b);
        Mockito.when(animalService.createAnimal(a)).thenReturn(a);
        Animal animal = this.restTemplate.postForObject("http://localhost:" + port + "/animals",a,
                Animal.class);
        assertEquals(animal.getId(), animal.getId());
    }
}
