package edu.eci.arsw.Eturnity.controllers;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import edu.eci.arsw.Eturnity.services.TurnoServices;
import edu.eci.arsw.Eturnity.services.UserServices;
import java.util.Random;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/turno")
public class TurnoController {
    @Autowired
    TurnoServices ts;
    @Autowired
    UserServices us;

    @RequestMapping(method=RequestMethod.GET, path="turnos")
    public ResponseEntity<?> getAllTurnos(){
        try{
            String resp = new Gson().toJson(ts.getAllTurnos());
            return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);       
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.GET,path ="/turnos/{user}")
    public ResponseEntity<?> getTurnosByUsername(@PathVariable("user") String usuario){
        try{
            List<Turno> turnos = new ArrayList<>();
            turnos = ts.getTurnosByUsername(usuario);
            String resp = new Gson().toJson(turnos);
            return  new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
        } catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }
       
    }

    @RequestMapping (method = RequestMethod.GET, path="/turnoss/{sede}")
    public ResponseEntity<?> getTurnosBySede(@PathVariable("sede") String sede){
        try{
            List<Turno> turnos = new ArrayList<>();
            turnos = ts.getTurnosBySede(sede);
            String resp = new Gson().toJson(turnos);
            return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null,ex);
            return new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method=RequestMethod.GET, path = {"turnofecha/{fecha}"})
    public ResponseEntity<?> getTurnosByFecha(@PathVariable("fecha") String fecha){
        try{
            System.out.println("controller");
            List<Turno> turnos = new ArrayList<>();
            turnos = ts.getTurnoByFecha(fecha);
            String resp = new Gson().toJson(turnos);
            return new ResponseEntity<>(resp,HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.GET,path="valido")
    public ResponseEntity<?> getTurnosValidos(){
        try{
            List <Turno> turnos = new ArrayList<>();
            turnos = ts.getAllTurnosValido(true);
            String resp = new Gson().toJson(turnos);
            return new ResponseEntity<> (resp, HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping (method = RequestMethod.POST, path="turnocre")
    public ResponseEntity<?> createTurno(@RequestBody String turno){
        try{
            Type lisType = new TypeToken<Map<Integer,Turno>>(){
            }.getType();
            //Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
            Map<String,Turno> resp = new Gson().fromJson(turno, lisType);
            Object [] key = resp.keySet().toArray();
            Turno turn = resp.get(key[0]);
            
            //Turno Valido
            turn.setValido(true);
            //Asignar identifier 
            ObjectId newObjectIdUser = new ObjectId(new Date());
            turn.setIdentifier(newObjectIdUser.toHexString());
            //Asignar Modulo
            Random rn = new Random();
            int randomNum = rn.nextInt((10 - 1) + 1) + 1;
            String num= String.valueOf(randomNum);
            turn.setModulo(num);
            System.out.println(turn.getModulo() + "  <.----- el modulo");
            //Asignar id correcto.
            turn.setId(ts.getSiguienteTurno(turn.getTurnosedeid()));
            
            ts.createTurno(turn);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path="turnodeleted/{username}/{identifier}")
    public ResponseEntity<?> deleteTurnoByUsername(@PathVariable ("identifier") String identifier, @PathVariable ("username") String username){
        try{
            Usuario u = us.getUser(username);
            ts.deleteTurnoByUsername(identifier, u.getUsername());
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR AL ELIMINAR EL TURNO"+identifier,HttpStatus.FORBIDDEN);
        }
    }
}

