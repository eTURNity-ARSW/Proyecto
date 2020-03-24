package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;



public interface TurnoRepository  extends CrudRepository<Turno,String> {
    public Turno findByIdentifier(String id);
    public List<Turno> findByUser(String user);
    public List<Turno> findBySede(String sede);
   /*public List<Turno> findByValido();*/
   
    public List<Turno> findByFecha(Date fecha);
}
