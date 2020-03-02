package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.Bath;
import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.BathService;
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
public class TestBath {

    @MockBean
    private BathService bathService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Bath> P = new ArrayList<Bath>();
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        P.add(new Bath("test1", 0L, 0.0, Bath.State.clean, s,e));
        P.add(new Bath("test2", 0L, 0.0, Bath.State.clean, s,e));
        P.add(new Bath("test3", 0L, 0.0, Bath.State.clean, s,e));
        Bath p = P.get(0);
        Mockito.when(bathService.getAll()).thenReturn(P);
        List<Bath> baths = this.restTemplate.getForObject("http://localhost:" + port + "/baths",
                List.class);
        assertEquals(3, baths.size());
    }

    @Test
    public void create() {
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Bath b=new Bath("test", 0L, 0.0, Bath.State.clean, s,e);
        Mockito.when(bathService.createBath(b)).thenReturn(b);
        Bath bath = this.restTemplate.postForObject("http://localhost:" + port + "/baths",b,
                Bath.class);
        assertEquals(bath.getId(), bath.getId());
    }
}
