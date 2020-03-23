package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EnterpriseRepository extends CrudRepository<Entidad,String> {
    public List<Entidad> findByNombre(String name);
    public List<Entidad> findByNit(String nit);
    public List<Entidad> findByCiudad(String city);
}
