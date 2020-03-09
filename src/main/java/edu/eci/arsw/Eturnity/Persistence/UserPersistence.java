package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserPersistence  {

    public Usuario getUsuarioByUsername(String name);
    public boolean conexionDB();
    public boolean saveUser(Usuario user) throws UserException;
    public Usuario getUser(String username);
    public List<Usuario> getAll();
}
