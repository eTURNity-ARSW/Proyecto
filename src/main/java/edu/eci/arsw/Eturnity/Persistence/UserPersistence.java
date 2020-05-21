package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.exceptions.UserException;
import edu.eci.arsw.Eturnity.model.Usuario;


import java.util.List;


public interface UserPersistence  {

    public Usuario getUsuarioByUsername(String name) throws UserException;
    public boolean saveUser(Usuario user) throws UserException;
    public List<Usuario> getAll() throws UserException;
    public void createNewUser(Usuario u) throws UserException;
    public void deleteUser(String u) throws UserException;
}
