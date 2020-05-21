package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.cache.UsuarioCache;
import edu.eci.arsw.Eturnity.exceptions.UserException;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserPersistence usp;
    @Autowired
    private TurnoPersistence tsp;
    @Autowired
    private UsuarioCache usc;

    public boolean saveUser(Usuario user) throws UserException {
        return usp.saveUser(user);
    }
    public Usuario getUser(String username) throws UserException {
        System.out.println("Entre a try");
        System.out.println("username"+username);
        if (!usc.findUser(username)){
            usc.addUserCache(usp.getUsuarioByUsername(username));
        }
        return usc.getCacheUser(username);
    }

    public List<Usuario> getAllUsers() throws UserException {
        return usp.getAll();
    }

    public void createNewUser(Usuario u) throws UserException{
         usp.createNewUser(u);
    }

    public void deleteUser(String u) throws UserException{
        usp.deleteUser(u);
    }

   

}

