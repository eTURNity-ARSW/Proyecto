package edu.eci.arsw.Eturnity.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.Response;

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.model.Usuario;
import edu.eci.arsw.Eturnity.services.UserServices;

@RestController
@RequestMapping( value = "/usuario")
public class UsuarioController {

    @Autowired
    private UserServices us;

    @RequestMapping(method = RequestMethod.GET, path = "users")
    public ResponseEntity<?> getAllUsers(){
        try {
            String resp = new Gson().toJson(us.getAllUsers());
            return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);
        } catch (UserException e) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method=RequestMethod.POST , path= "login")
    public ResponseEntity<?> loginUser(@RequestBody String u){
        try{
           // System.out.println("Entro login");
            Type list = new TypeToken<Map<Integer,Usuario>>(){
            }.getType();
            Map<String,Usuario> resp = new Gson().fromJson(u, list);
            Object [] key = resp.keySet().toArray();
            Usuario user = resp.get(key[0]);
            us.createNewUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
       
    }


    @RequestMapping (method=RequestMethod.DELETE,path="deleted/{username}")
    public ResponseEntity<?> deleteByUsername(@PathVariable ("username") String username){
        try{
            us.deleteUser(username);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch(Exception ex){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
    }

    @RequestMapping(path ="/users/{username}",method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        try {
            System.out.println("holi1");
            Usuario u = us.getUser(username);
            System.out.println("holi2");
            String data = new Gson().toJson(u);
            System.out.println("holi3");
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            System.out.println("holi4");
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
