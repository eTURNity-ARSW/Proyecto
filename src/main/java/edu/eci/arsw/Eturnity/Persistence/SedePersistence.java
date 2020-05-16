package edu.eci.arsw.Eturnity.Persistence;

import java.util.List;

import edu.eci.arsw.Eturnity.model.Sede;

public interface SedePersistence {
    
    public List<Sede> getAllSedes();
    public List<Sede> getSedesByEntidad(String idEntidad);
    public List<Sede> getSedesByEntidadYCiudad(String idEntidad, String ciudad);
    public void createSede(Sede sd);
	public void deleteSede(String id);
}

