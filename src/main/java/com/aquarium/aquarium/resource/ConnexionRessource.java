package com.aquarium.aquarium.resource;

import com.aquarium.aquarium.model.Employee;
import com.aquarium.aquarium.service.ConnexionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@RestController
public class ConnexionRessource {
    @Autowired
    private ConnexionService connexionService;

    private static Map<String, Employee> connexions = new HashMap<String, Employee>();

    public static Employee getEmployee(String key) {
        if (connexions.containsKey(key)) {
            return connexions.get(key);
        }
        return null;
    }

    @RequestMapping(path = "/connect/{login}/{password}", method = RequestMethod.GET)
    public String connect(@PathVariable String login, @PathVariable String password) {
        try {
            UUID uuid = UUID.randomUUID();
            connexions.put(uuid.toString(), connexionService.getEmployee(login, password).get());
            return uuid.toString();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "wrong login and password");
        }
    }

    @RequestMapping(path = "/manager/{login}/{password}", method = RequestMethod.GET)
    public boolean manager(@PathVariable String login, @PathVariable String password) {
        return connexionService.getEmployee(login, password).get().isManager();
    }

    @RequestMapping(path = "/id/{login}/{password}", method = RequestMethod.GET)
    public long id(@PathVariable String login, @PathVariable String password) {
        return connexionService.getEmployee(login, password).get().getId();
    }

    @GetMapping("/disconnect/{key}")
    public boolean disconnect(@PathVariable String key) {
        if (connexions.containsKey(key)) {
            connexions.remove(key);
        }
        return true;
    }
}
