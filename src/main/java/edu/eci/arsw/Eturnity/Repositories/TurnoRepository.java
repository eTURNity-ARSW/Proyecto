package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface TurnoRepository  extends CrudRepository<Turno,String> {
    public Turno findByIdentifier(String id);
    public List<Turno> findByUser(String user);
    public List<Turno> findBySede(String sede);
}
