package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserPersistence usp;
    public void getUser(){
        usp.getUsuarioByUsername("pepito");
    }
}

