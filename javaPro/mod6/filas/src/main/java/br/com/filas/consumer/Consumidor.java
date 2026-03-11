package br.com.filas.consumer;

import br.com.filas.config.ConfigRabbitMQ;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = ConfigRabbitMQ.NOME_FILA)
public class Consumidor {

    @RabbitHandler
    public void consumirMensagem(String mensagem) {
        System.out.println("=============recebendo mensagem=============");
        System.out.println(mensagem);
        System.out.println("===========fim da mensagem ===================");
    }
}
