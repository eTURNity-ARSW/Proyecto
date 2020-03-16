package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.data.repository.CrudRepository;


public interface TurnoRepository  extends CrudRepository<Turno,String> {
    public Turno findByid(String id);
    public Turno findByUsername(String username);
}
