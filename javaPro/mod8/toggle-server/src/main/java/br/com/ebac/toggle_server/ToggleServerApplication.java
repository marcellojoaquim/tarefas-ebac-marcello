package br.com.ebac.toggle_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ToggleServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToggleServerApplication.class, args);
	}

}
