package br.com.filas.service;

import br.com.filas.config.ConfigRabbitMQ;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoRabbitMQ {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviaMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(ConfigRabbitMQ.NOME_EXCHANGE, "ebac.rota.mensagem", mensagem);
    }
}
