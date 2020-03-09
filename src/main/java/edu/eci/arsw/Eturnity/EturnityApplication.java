package edu.eci.arsw.Eturnity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("edu.eci.arsw.Eturnity.Repositories")
@ComponentScan(basePackages= {"com.modeler"})
@ComponentScan(basePackages = {"Eturnity"})
public class EturnityApplication {

	public static void main(String[] args) {
		SpringApplication.run(EturnityApplication.class, args);
	}

}
