package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserPersistence  {

    public Usuario getUsuarioByUsername(String name) throws UserException;
    public boolean saveUser(Usuario user) throws UserException;
    public Usuario getUserByName(String username);
    public List<Usuario> getAll();
}
