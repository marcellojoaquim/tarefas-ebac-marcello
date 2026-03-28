package br.com.ebac.demo_mongodb.controller;

import br.com.ebac.demo_mongodb.model.Jogo;
import br.com.ebac.demo_mongodb.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService service;

    @PostMapping
    public Jogo createJogo(@RequestBody Jogo jogo) {
        return service.createJogo(jogo);
    }

    @DeleteMapping("/{id}")
    public void deleteJogo(@PathVariable String id) {
        service.deleteJogo(id);
    }

    @GetMapping("/{id}")
    public Optional<Jogo> findJogo(@PathVariable String id) {
        return service.findJogo(id);
    }
}
