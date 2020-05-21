package edu.eci.arsw.Eturnity.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import edu.eci.arsw.Eturnity.exceptions.EntidadException;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.services.EntidadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/entidades")
public class EntidadController {
    @Autowired
    EntidadServices es;

    @RequestMapping(method=RequestMethod.GET, path="entities")
    public ResponseEntity<?> getAllEntidades() {
        try{
            System.out.println("entra");
            String resp = new Gson().toJson(es.getAllEntidades());
            System.out.println("Lo mande al servicio");
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<> ("ERROR",HttpStatus.NOT_FOUND);
        }

    }


    @RequestMapping(path="/entidad/{nombre}", method = RequestMethod.GET)
    public ResponseEntity<?> getEntity(@PathVariable("nombre") String nombre){
        try{
            Entidad e =es.getEnterprise(nombre);
            String data = new Gson().toJson(e);
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (EntidadException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }
    

    @RequestMapping(method = RequestMethod.POST, path="entidadcre")
    public ResponseEntity<?> createEntidad(@RequestBody String entidad){
        try{
            Type lisType = new TypeToken<Map<Integer,Entidad>>(){
            }.getType();
            Map<String,Entidad> resp = new Gson().fromJson(entidad,lisType);
            Object[] key = resp.keySet().toArray();
            Entidad e = resp.get(key[0]);
            es.createEntidad(e);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path="entidadel/{nit}")
    public ResponseEntity<?> deleteEntidad(@PathVariable("nit") String nit){
        try{
            es.deleteEntidad(nit);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }

}


