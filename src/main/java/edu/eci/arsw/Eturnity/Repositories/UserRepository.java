package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuario, String> {

    @Query("SELECT u FROM Usuario u WHERE u.username = :name")
    public Usuario getUsuarioByName(@Param("name") String name);
    public boolean saveUser(Usuario user) throws Exception;
    public Usuario getUser(String username);
    public List<Usuario> getAll();
}
