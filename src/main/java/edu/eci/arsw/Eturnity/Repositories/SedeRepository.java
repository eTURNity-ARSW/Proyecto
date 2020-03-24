package edu.eci.arsw.Eturnity.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import edu.eci.arsw.Eturnity.model.Sede;

public interface SedeRepository extends CrudRepository<Sede,String> {
    public List<Sede> findByIdentifier(String identificador);
    public List<Sede> findAll();
    public List<Sede> findByCiudad(String ciudad);
	


}
