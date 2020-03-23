package edu.eci.arsw.Eturnity.controllers;

import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping( value = "/usuario")
public class EturnityController {

    @Autowired
    private UserServices us = null;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> GetAllUsers(){
        try {
            return new ResponseEntity<>(us.getAllUsers(), HttpStatus.ACCEPTED);
        } catch (UserException e) {
            Logger.getLogger(EturnityController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/{user}",method = RequestMethod.GET)
    public ResponseEntity<?> GetUser(@PathVariable("user") String username){
        try {
            return new ResponseEntity<>(us.getUser(username),HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(EturnityController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path ="/{user}/turns",method = RequestMethod.GET)
    public ResponseEntity<?> GetTurnsByUser(@PathVariable("user") String username){
        try {
            return new ResponseEntity<>(us.getUser(username).getTurnos(),HttpStatus.ACCEPTED);
        } catch (UserException ex) {
            Logger.getLogger(EturnityController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
