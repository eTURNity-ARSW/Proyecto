package edu.eci.arsw.Eturnity;

import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"edu.eci.arsw.Eturnity"})
public class EturnityApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EturnityApplication.class);
	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EturnityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(" Iniciando Eturnity Application...");

		repository.save(new Usuario("1","Pepito", "pepito@gmail.com", "1072", "123"));

		System.out.println("\nfindAll()");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1)");
		repository.findById("1").ifPresent(x -> System.out.println(x));
		System.out.println("\nfindByName('Pepito')");
		repository.findByNombre("Pepito").forEach(x -> System.out.println(x));
	}
}
