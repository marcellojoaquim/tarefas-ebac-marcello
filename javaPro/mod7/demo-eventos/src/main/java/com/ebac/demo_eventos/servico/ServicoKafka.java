package com.ebac.demo_eventos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ServicoKafka {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${kafka.ebac.nome.topico}")
    private String nomeTopico;

    public void enviarMensagem(String mensagem) {
        System.out.println("=========== ENVIANDO MENSAGEM =========");
        kafkaTemplate.send(nomeTopico, mensagem);
    }
}
