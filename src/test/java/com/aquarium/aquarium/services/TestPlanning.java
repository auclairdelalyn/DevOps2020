package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.Bath;
import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.model.Planning;
import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.PlanningService;
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
public class TestPlanning {

    @MockBean
    private PlanningService planningService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Planning> P = new ArrayList<Planning>();
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Bath b=new Bath("test", 0L, 0.0, Bath.State.clean, s,e);
        Set<Employee>employees=new HashSet<Employee>();
        employees.add(e);
        P.add(new Planning("test1", 0L, 0L, Planning.Day.everyday, true, employees, b));
        P.add(new Planning("test2", 0L, 0L, Planning.Day.everyday, true, employees, b));
        P.add(new Planning("test3", 0L, 0L, Planning.Day.everyday, true, employees, b));
        Planning p = P.get(0);
        Mockito.when(planningService.getAll()).thenReturn(P);
        List<Planning> plannings = this.restTemplate.getForObject("http://localhost:" + port + "/plannings",
                List.class);
        assertEquals(3, plannings.size());
    }

    @Test
    public void create() {
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Bath b=new Bath("test", 0L, 0.0, Bath.State.clean, s,e);
        Set<Employee>employees=new HashSet<Employee>();
        employees.add(e);
        Planning p=new Planning("test", 0L, 0L, Planning.Day.everyday, true, employees, b);
        Mockito.when(planningService.createPlanning(p)).thenReturn(p);
        Planning planning = this.restTemplate.postForObject("http://localhost:" + port + "/plannings",p,
                Planning.class);
        assertEquals(planning.getId(), planning.getId());
    }
}
