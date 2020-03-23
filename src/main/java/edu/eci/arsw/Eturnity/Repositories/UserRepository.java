package edu.eci.arsw.Eturnity.Repositories;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<Usuario,String> {

    public Usuario findByNombre(String name);
    public Usuario findByUsername(String username);
    public Usuario findByCorreo(String correo);
}
