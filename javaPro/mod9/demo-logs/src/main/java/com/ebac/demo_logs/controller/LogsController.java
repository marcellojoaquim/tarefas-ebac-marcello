package com.ebac.demo_logs.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/logs")
public class LogsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsController.class);

    @Value("${servico2.url:}")
    private String urlServico2;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String getMessage() {
        final double message = Math.random();

        LOGGER.info("Gerei a mensagem: {}", message);

        if(urlServico2.length() > 0){
            final String messageDeles = restTemplate.exchange(
                    urlServico2,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<String>() {}
            ).getBody();

            return "Eu disse isso: "+message + "e eles disseram (" + messageDeles +" )";
        }

        return "Eu devo parar aqui.";
    }
}
