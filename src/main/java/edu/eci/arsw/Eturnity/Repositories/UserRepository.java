package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {

    public boolean saveUser(Usuario user) throws Exception;
    public Usuario getUser(String username);
    public List<Usuario> getAll();
}
