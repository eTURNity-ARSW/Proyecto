package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Usuario,String> {

    public Usuario findByNombre(String name);
    public Usuario findByUsername(String username);
    public Usuario findByCorreo(String correo);
}
