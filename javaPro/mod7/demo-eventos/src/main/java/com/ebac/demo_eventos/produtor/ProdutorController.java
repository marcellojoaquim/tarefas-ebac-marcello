package com.ebac.demo_eventos.produtor;

import com.ebac.demo_eventos.servico.ServicoKafka;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class ProdutorController {

    @Autowired
    private ServicoKafka servicoKafka;

    @PostMapping
    public void enviaMensagem(@RequestBody String mensagem) {
        servicoKafka.enviarMensagem(mensagem);
    }
}
