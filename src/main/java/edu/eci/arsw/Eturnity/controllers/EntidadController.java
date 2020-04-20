package edu.eci.arsw.Eturnity.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
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
@RequestMapping(value="/entidades")
public class EntidadController {
    @Autowired
    private EntidadServices es=null;

    @RequestMapping(method=RequestMethod.GET, path="entities")
    public ResponseEntity<?> getAllEntidades() {
        try{
            System.out.println("entra");
            String resp = new Gson().toJson(es.getAllEntidades());
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE,null,ex);
             return new ResponseEntity<> (ex.getMessage(),HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(path="/entidad/{sede}",method=RequestMethod.GET)
    public ResponseEntity<?> getSedeByEntidad(@PathVariable("nit") String nit) throws EntidadException{
        ResponseEntity<?> ans;
        try{
            List<Sede> entidades=es.getOfficeByEnterprise(nit);
            ans= new ResponseEntity<>(entidades,HttpStatus.ACCEPTED);
            
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE,null,ex);
            ans = new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }

    @RequestMapping(path="/entidad/{servicio}",method=RequestMethod.GET)
    public ResponseEntity<?> getServicioByEntidad(@PathVariable("nit")String nit) throws EntidadException{
        ResponseEntity<?> ans;
        try{
            List<Servicio> entidades=es.getServicesByEnterprise(nit);
            ans=new ResponseEntity<>(entidades,HttpStatus.ACCEPTED);
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE, null, ex);
            ans = new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }

    @RequestMapping(path="/entidad/{ciudad}",method=RequestMethod.GET)
    public ResponseEntity<?> getEntidadByCiudad(@PathVariable("city")String city) throws EntidadException{
        ResponseEntity<?> ans;
        try{
            List<Entidad> entidades=es.getEnterpriseByCity(city);
            ans=new ResponseEntity<>(entidades,HttpStatus.ACCEPTED);
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE, null, ex);
            ans = new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }


    @RequestMapping(path="/entidad/{turno}",method=RequestMethod.GET)
    public ResponseEntity<?> getTurnoByEntidad(@PathVariable("nit")String nit) throws EntidadException, TurnoException{
        ResponseEntity<?> ans;
        try{
            HashMap<Sede,ArrayList<Turno>> entidades=es.getTurnByEnterprise(nit);
            ans=new ResponseEntity<>(entidades,HttpStatus.ACCEPTED);
        }catch(EntidadException ex){
            Logger.getLogger(EntidadController.class.getName()).log(Level.SEVERE, null, ex);
            ans = new ResponseEntity<>("ERROR",HttpStatus.NOT_FOUND);
        }
        return ans;
    }




}


