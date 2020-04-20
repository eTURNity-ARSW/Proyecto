package edu.eci.arsw.Eturnity;


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
public class EturnityApplication{
	public static void main(String[] args) {
		SpringApplication.run(EturnityApplication.class, args);
	}

}
