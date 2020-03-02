package com.aquarium.aquarium.services;

import com.aquarium.aquarium.model.Species;
import com.aquarium.aquarium.service.SpeciesService;
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
public class TestSpecies {

    @MockBean
    private SpeciesService speciesService;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll() {
        List<Species> P = new ArrayList<Species>();
        P.add(new Species("test1", 0L, Species.Regime.Piscivore, 10));
        P.add(new Species("test2", 0L, Species.Regime.Piscivore, 10));
        P.add(new Species("test3", 0L, Species.Regime.Piscivore, 10));
        Species p = P.get(0);
        Mockito.when(speciesService.getAll()).thenReturn(P);
        List<Species> speciess = this.restTemplate.getForObject("http://localhost:" + port + "/species",
                List.class);
        assertEquals(3, speciess.size());
    }

    @Test
    public void create() {
        Species s=new Species("test", 0L, Species.Regime.Piscivore, 10);
        Mockito.when(speciesService.createSpecies(s)).thenReturn(s);
        Species species = this.restTemplate.postForObject("http://localhost:" + port + "/species",s,
                Species.class);
        assertEquals(species.getId(), species.getId());
    }
}
