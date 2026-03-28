package br.com.ebac.demo_mongodb.service;

import br.com.ebac.demo_mongodb.model.Jogo;
import br.com.ebac.demo_mongodb.repository.IJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableMongoRepositories(basePackageClasses = IJogoRepository.class)
public class JogoService {

    @Autowired
    private IJogoRepository repository;

    public Jogo createJogo(Jogo jogo) {
        return repository.insert(jogo);
    }
    public void deleteJogo(String id) { repository.deleteById(id); }
    public Optional<Jogo> findJogo(String id) { return repository.findById(id); }
}
