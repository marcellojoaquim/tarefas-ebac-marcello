package br.com.ebac.toggle_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    @Value("${mensagem:Não tenho mensagem padrão}")
    private String mensagem;

    @Value("${ligaDesliga:false}")
    private boolean ligaDesliga;

    @GetMapping
    public String getMensagem() {
        if(ligaDesliga){
            return this.mensagem;
        }
        return "Funcionalidade Desligada";
    }
}
