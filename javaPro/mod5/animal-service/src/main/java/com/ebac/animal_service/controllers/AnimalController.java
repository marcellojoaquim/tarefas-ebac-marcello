package com.ebac.animal_service.controllers;

import com.ebac.animal_service.dto.QtdAnimaisResgatados;
import com.ebac.animal_service.entities.Animal;
import com.ebac.animal_service.repository.AnimalRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/recebedor/{nomeRecebedor}")
    private QtdAnimaisResgatados countAnimalsByRecebedor(@PathVariable("nomeRecebedor") String nomeRecebedor,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate inicio,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate fim)
    {
        if(inicio.isAfter(fim)) throw new IllegalArgumentException("Intervalo inválido.");
        if(fim.plusYears(1).isBefore(fim)) throw new IllegalArgumentException("Intervalo inválido");
        return new QtdAnimaisResgatados(repository.countAnimalsBetweenDate(nomeRecebedor, inicio, fim));
    }
}
