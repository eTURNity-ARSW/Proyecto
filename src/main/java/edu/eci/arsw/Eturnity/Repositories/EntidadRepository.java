package edu.eci.arsw.Eturnity.Repositories;

import edu.eci.arsw.Eturnity.model.Entidad;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface EntidadRepository extends CrudRepository<Entidad,String> {
    public List<Entidad> findByNombre(String name);
    public List<Entidad> findByNit(String nit);
    public List<Entidad> findByCiudad(String city);
}
