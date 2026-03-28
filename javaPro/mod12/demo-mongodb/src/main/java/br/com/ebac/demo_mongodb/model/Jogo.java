package br.com.ebac.demo_mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Jogo")
public class Jogo {

    @Id
    private String id;
}
