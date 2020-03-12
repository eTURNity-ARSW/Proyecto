package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends CrudRepository<Usuario,String> {

    public List<Usuario> findByNombre(String name);
    public Usuario findByUsername(String username);
    public List<Usuario> findByCorreo(String correo);
    public List<Usuario> findByDocumento(String documento);
    public List<Usuario> findByContrasena(String password);
}
