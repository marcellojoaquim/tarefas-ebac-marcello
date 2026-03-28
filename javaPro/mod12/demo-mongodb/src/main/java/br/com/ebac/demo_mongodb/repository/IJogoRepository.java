package br.com.ebac.demo_mongodb.repository;

import br.com.ebac.demo_mongodb.model.Jogo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IJogoRepository extends MongoRepository<Jogo, String> {
    long count();
}
