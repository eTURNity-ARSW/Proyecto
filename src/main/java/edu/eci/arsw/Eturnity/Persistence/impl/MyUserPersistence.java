package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.UserException;
import edu.eci.arsw.Eturnity.Persistence.UserPersistence;
import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyUserPersistence implements UserPersistence {
    @Autowired
    private UserRepository repository;

    @Override
    public Usuario getUsuarioByUsername(String username) {
        Usuario byUsername = repository.findByUsername(username);
        if(byUsername != null){
            return byUsername;
        }
        return null;
    }

    @Override
    public boolean conexionDB() {

        return false;
    }

    @Override
    public boolean saveUser(Usuario user) throws UserException {
        return false;
    }

    @Override
    public Usuario getUser(String username) {
        return null;
    }

    @Override
    public List<Usuario> getAll() {

        return (List<Usuario>) repository.findAll();
    }
}
