package edu.eci.arsw.Eturnity;

import edu.eci.arsw.Eturnity.Repositories.EnterpriseRepository;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"edu.eci.arsw.Eturnity"})
public class EturnityApplication implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(EturnityApplication.class);
	@Autowired
	UserRepository repository;
	@Autowired
	TurnoRepository trepo;
	@Autowired
	EnterpriseRepository erepo;

	public static void main(String[] args) {
		SpringApplication.run(EturnityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info(" Iniciando Eturnity Application...");
		Usuario Pepito = new Usuario("1", "Pepito", "pepito@gmail.com", "1072", "123");
		Entidad entidad = new Entidad("123-1", "Daviplata",  "Por ahí", "Bogotá", 123);
		Sede sede = new Sede("123-1.1", "Bogota", "Calle 222", new Date(), "123-1");
		Turno turno = new Turno("T1", "Transaccionn", "1", "123-1.1", new Date(), true);
		repository.save(Pepito);
		log.info(" PROBANDO USER REPOSITORY...");

		System.out.println("\nfindAll()");
		System.out.println("HOLA");
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(1)");
		repository.findById("1").ifPresent(x -> System.out.println(x));
		System.out.println("\nfindByName('Pepito')");
		System.out.println(repository.findByNombre("Pepito").toString());

		/**trepo.save(turno);
		log.info(" PROBANDO TURNO REPOSITORY...");

		System.out.println("\nfindAll()");
		trepo.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(T1)");
		System.out.println(trepo.findByIdentifier("T1").toString());
		System.out.println("\nfindByUserName(Pepito)");
		trepo.findByUser("1").forEach(x -> System.out.println(x));
		System.out.println("\nfindByUserName(Sede)");
		trepo.findBySede("123-1.1").forEach(x -> System.out.println(x));

		erepo.save(entidad);
		log.info(" PROBANDO ENTERPRISE REPOSITORY...");

		System.out.println("\nfindAll()");
		erepo.findAll().forEach(x -> System.out.println(x));

		System.out.println("\nfindById(T1)");
		erepo.findById("123-1").ifPresent(x -> System.out.println(x));
		System.out.println("\nfindByName('Daviplata')");
		erepo.findByNombre("Daviplata").forEach(x -> System.out.println(x));
		 */
	}
}
