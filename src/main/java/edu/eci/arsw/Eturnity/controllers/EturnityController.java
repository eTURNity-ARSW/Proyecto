package edu.eci.arsw.Eturnity.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( value = "/")
public class EturnityController {

    @RequestMapping(method = RequestMethod.GET)
    public String getMensaje() {
        return "Estamos reparando los servicios, sentimos los inconvenientes";

    }
}
