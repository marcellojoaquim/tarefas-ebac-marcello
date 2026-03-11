package br.com.filas.produtor;

import br.com.filas.service.ServicoRabbitMQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mensagens")
public class Produtor {

    @Autowired
    private ServicoRabbitMQ servicoRabbitMQ;

    @PostMapping
    public void enviaMensagem(@RequestBody String mensagem) {
        System.out.println("==================Enviando mensagem " + mensagem);
        servicoRabbitMQ.enviaMensagem(mensagem);
    }
}
