/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.Eturnity.controllers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.services.SedeServices;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping(value = "/sede")
public class SedeController {

    @Autowired
    SedeServices sService;

    @RequestMapping(method = RequestMethod.GET, path = "sedes")
    public ResponseEntity<?> getAllSedes() {
        try {
            String resp = new Gson().toJson(sService.getAllSedes());
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sedes/{entidad}")
    public ResponseEntity<?> getSedesByEntidad(@PathVariable("entidad") String idEntidad) {
        try {
            String resp = new Gson().toJson(sService.getSedesByEntidad(idEntidad));
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/sedes/misedes/{entidad}")
    public ResponseEntity<?> getMySedesByEntidad(@PathVariable("entidad") String nombreEntidad) {
        try {
            String resp = new Gson().toJson(sService.getMySedesByEntidad(nombreEntidad));
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/sedes/{entidad}/{ciudad}")
    public ResponseEntity<?> getSedesByEntidadYCiudad(@PathVariable("entidad") String nombreEntidad, @PathVariable("ciudad") String ciudad) {
        try {
            String resp = new Gson().toJson(sService.getSedesByEntidadYCiudad(nombreEntidad, ciudad));
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = "/{nombreEntidad}/{ciudad}/{nombreSede}")
    public ResponseEntity<?> getSedeByEntidadNameYSedeName(@PathVariable("nombreEntidad") String nombreEntidad,@PathVariable("ciudad") String ciudad, @PathVariable("nombreSede") String nombreSede) {
        try {
            String resp = new Gson().toJson(sService.getSedeByEntidadNameYSedeName(nombreEntidad, ciudad, nombreSede));
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            Logger.getLogger(TurnoController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST )
    public ResponseEntity<?> createSede(@RequestBody String sede) {
        // JSON 
        try {
            Type lisType = new TypeToken<Map<Integer, Sede>>() {
            }.getType();
            Map<String, Sede> resp = new Gson().fromJson(sede, lisType);
            Object[] key = resp.keySet().toArray();
            Sede sd = resp.get(key[0]);

            //Asignar identifier 
            ObjectId newObjectIdUser = new ObjectId(new Date());
            sd.setIdentificador(newObjectIdUser.toHexString());
            System.out.println(sd.getIdentificador());
            
            sService.createSede(sd);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("ERROR", HttpStatus.NOT_FOUND);
        }
    }



    @RequestMapping(method = RequestMethod.DELETE, path="sedes/{id}")
    public ResponseEntity<?> deleteSede(@PathVariable("id") String id){
        try{
            sService.deleteSede(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }catch(Exception ex){
            Logger.getLogger(SedeController.class.getName()).log(Level.SEVERE,null,ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }

}
