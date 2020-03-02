package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.Sector;
import com.aquarium.aquarium.service.SectorService;
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
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSector {

    @MockBean
    private SectorService sectorService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Sector> P = new ArrayList<Sector>();
        P.add(new Sector("test1", "test1"));
        P.add(new Sector("test2", "test2"));
        P.add(new Sector("test3", "test3"));
        Sector p = P.get(0);
        Mockito.when(sectorService.getAll()).thenReturn(P);
        List<Sector> sectors = this.restTemplate.getForObject("http://localhost:" + port + "/sectors",
                List.class);
        assertEquals(3, sectors.size());
    }

    @Test
    public void create() {
        Sector s=new Sector("test1", "test1");
        Mockito.when(sectorService.createSector(s)).thenReturn(s);
        Sector sector = this.restTemplate.postForObject("http://localhost:" + port + "/sectors",s,
                Sector.class);
        assertEquals(sector.getId(), sector.getId());
    }
}
