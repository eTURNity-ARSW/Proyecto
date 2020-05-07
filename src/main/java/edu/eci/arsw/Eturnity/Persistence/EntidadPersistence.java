package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;

public interface EntidadPersistence {

    public Entidad getEnterprise(String nombre) throws EntidadException;
    public List<Entidad> getAll();
    public Entidad getEnterpriseByName(String name) throws EntidadException;
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException;
	public void createEntidad(Entidad e);
    public void deleteEntidad(String e);
    public List<Entidad> getAllEntidades();
}
