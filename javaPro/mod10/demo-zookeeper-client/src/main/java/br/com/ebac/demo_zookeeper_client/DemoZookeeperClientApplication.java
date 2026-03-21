package br.com.ebac.demo_zookeeper_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoZookeeperClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoZookeeperClientApplication.class, args);
	}

}
