package edu.eci.arsw.Eturnity.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.services.TurnoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/turno")
public class TurnoController {
    @Autowired
    TurnoServices ts;

    @RequestMapping(method=RequestMethod.GET, path="turnos")
    public ResponseEntity<?> getAllTurnos() throws TurnoException{
        try{
            String resp = new Gson().toJson(ts.getAllTurnos());
            return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);       
        }catch(TurnoException ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.GET,path ="/turno/{user}")
    public ResponseEntity<?> getTurnoByUsuario(@PathVariable("usuario") String usuario) throws TurnoException{
        try{
            List<Turno> turnos = new ArrayList<>();
            turnos = ts.getTurnsByUser(usuario);
            String resp = new Gson().toJson(turnos);
            return  new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
        } catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }
       
    }

    /*@RequestMapping(path="/turno",method=RequestMethod.GET)
    public ResponseEntity<?> getTurnosValidos() throws TurnoException{
        ResponseEntity<?> ans;
        try{
            List<Turno> turnos = ts.getAllValidTurnos();
            ans = new ResponseEntity<>(turnos,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE,null, ex);
            ans = new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
        return ans;
    }*/

    @RequestMapping(path="/turno/{fecha}",method=RequestMethod.GET)
    public ResponseEntity<?> getTurnosByFecha(@PathVariable("fecha") Date fecha) throws TurnoException{
        ResponseEntity<?> ans;
        try{
            List<Turno> turnos=ts.getTurnosFecha(fecha);
            ans= new ResponseEntity<>(turnos,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            ans= new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }

    @RequestMapping(path="/turno/{sede}",method=RequestMethod.GET)
    public ResponseEntity<?> getTurnosBySede(@PathVariable("sede") String sede) throws TurnoException{
        ResponseEntity<?> ans;
        try{
            List<Turno> turnos=ts.getTurnsBySede(sede);
            ans = new ResponseEntity<>(turnos,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            ans= new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);

        }   
        return ans;

    }



}

