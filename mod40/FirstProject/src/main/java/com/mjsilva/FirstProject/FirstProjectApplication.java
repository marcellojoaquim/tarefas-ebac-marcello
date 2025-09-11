package com.mjsilva.FirstProject;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mjsilva.domain.Cliente;
import com.mjsilva.repository.IClienteRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.mjsilva.repository")
@EntityScan("com.mjsilva.*")
@ComponentScan(basePackages = "com.mjsilva")
public class FirstProjectApplication implements CommandLineRunner{
	
	private static final Logger logger = LoggerFactory.getLogger(FirstProjectApplication.class);
	
	@Autowired
	private IClienteRepository repository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Start running");
		Cliente cliente = createCliente();
		repository.save(cliente);
		
	}
	
	private Cliente createCliente() {
		return Cliente.builder().
				cidade("PE")
				.cpf(12345678900L)
				.email("cliente@teste.com")
				.end("Endereco teste")
				.estado("PE")
				.name("Teste primeiro projeto spring")
				.numero(8080)
				.tel(80808081L)
				.build();
	}

}
