package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.exceptions.EntidadException;
import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;

public interface EntidadPersistence {

    public Entidad getEnterprise(String nombre) throws EntidadException;
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException;
	public void createEntidad(Entidad e) throws EntidadException;
    public void deleteEntidad(String e) throws EntidadException;
    public List<Entidad> getAllEntidades() throws EntidadException;
}
