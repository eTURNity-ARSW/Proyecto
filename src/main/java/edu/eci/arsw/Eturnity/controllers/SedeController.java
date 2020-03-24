package edu.eci.arsw.Eturnity.controllers;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.eci.arsw.Eturnity.Persistence.EntidadException;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Servicio;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.services.EntidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/sedes")
public class SedeController {
}
