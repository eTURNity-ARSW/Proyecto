package edu.eci.arsw.Eturnity.controllers;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;
import java.util.List;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.Map;
import java.util.Date;
import org.bson.types.ObjectId;
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
            System.out.println("Entro1");
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
            System.out.println("Entro login");
            Type list = new TypeToken<Map<Integer,Usuario>>(){
            }.getType();
            Map<String,Usuario> resp = new Gson().fromJson(u, list);
            Object [] key = resp.keySet().toArray();
            Usuario user = resp.get(key[0]);
            ObjectId idUser = new ObjectId(new Date());
            user.setUsername(idUser.toHexString());
            us.createNewUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch(Exception e){
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
       
    }

    @RequestMapping(path ="/users/{username}",method = RequestMethod.GET)
    public ResponseEntity<?> getUser(@PathVariable("username") String username){
        try {
            System.out.println(username + "  <--- username");
            Usuario u = us.getUser(username);
            String data = new Gson().toJson(u);
            return new ResponseEntity<>(data,HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/{user}/turns",method = RequestMethod.GET)
    public ResponseEntity<?> getTurnsByUser(@PathVariable("user") String username){
        try {
            return new ResponseEntity<>(us.getUser(username).getTurnos(),HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
