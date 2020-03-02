package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.Bath;
import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.EmployeeService;
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
public class TestEmployee {

    @MockBean
    private EmployeeService employeeService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Employee> P = new ArrayList<Employee>();
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        P.add(new Employee("test1","test", "test", "test", "test", sectors, "test", "test", true));
        P.add(new Employee("test2","test", "test", "test", "test", sectors, "test", "test", true));
        P.add(new Employee("test3","test", "test", "test", "test", sectors, "test", "test", true));
        Employee p = P.get(0);
        Mockito.when(employeeService.getAll()).thenReturn(P);
        List<Employee> employees = this.restTemplate.getForObject("http://localhost:" + port + "/employees",
                List.class);
        assertEquals(3, employees.size());
    }

    @Test
    public void create() {
        Sector s=new Sector("test1", "test1");
        Set<Sector> sectors=new HashSet<Sector>();
        sectors.add(s);
        Employee e=new Employee("test","test", "test", "test", "test", sectors, "test", "test", true);
        Mockito.when(employeeService.createEmployee(e)).thenReturn(e);
        Employee employee = this.restTemplate.postForObject("http://localhost:" + port + "/employees",e,
                Employee.class);
        assertEquals(employee.getId(), employee.getId());
    }
}
