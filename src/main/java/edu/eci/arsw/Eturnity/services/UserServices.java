package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private UserPersistence usp;

    public Usuario getUser(String username){
        return usp.getUsuarioByUsername(username);
    }


}

