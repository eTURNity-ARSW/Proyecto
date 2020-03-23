package edu.eci.arsw.Eturnity.controllers;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.services.TurnoServices;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/turnos")
public class TurnoController {
    @Autowired
    TurnoServices ts;

    @RequestMapping(method=RequestMethod.GET)
    public ResponseEntity<?> getAllTurnos() throws TurnoException{
        ResponseEntity ans;
        try{
            List<Turno> turnos= ts.getAllTurnos();
            ans=new ResponseEntity<>(turnos, HttpStatus.ACCEPTED);
        }catch(TurnoException ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE,null,ex);
            ans = new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }



}

