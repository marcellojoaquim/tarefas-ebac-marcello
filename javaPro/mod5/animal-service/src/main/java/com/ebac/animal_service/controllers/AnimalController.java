package com.ebac.animal_service.controllers;

import com.ebac.animal_service.entities.Animal;
import com.ebac.animal_service.repository.AnimalRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private final AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll(){
        return repository.findAll();
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/died")
    private List<Animal> findDied() {
        return repository.findDied();
    }

    @GetMapping("/specie/{especie}")
    private List<Animal> findByEspecie(@PathVariable String especie) {
        return repository.findByEspecie(especie);
    }
}
