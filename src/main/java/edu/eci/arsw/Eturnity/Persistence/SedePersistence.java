package edu.eci.arsw.Eturnity.Persistence;

import java.util.List;

import edu.eci.arsw.Eturnity.exceptions.SedeException;
import edu.eci.arsw.Eturnity.model.Sede;

public interface SedePersistence {

    public List<Sede> getAllSedes() throws SedeException;

    public List<Sede> getMySedesByEntidad(String nombreEntidad)  throws SedeException;

    public List<Sede> getSedesByEntidad(String idEntidad)  throws SedeException;

    public List<Sede> getSedesByEntidadYCiudad(String nombreEntidad, String ciudad)  throws SedeException;

    public void createSede(Sede sd)  throws SedeException;

    public void deleteSede(String id)  throws SedeException;
    
    public Sede getSedeByEntidadNameYSedeName(String nombreEntidad, String ciudad, String nombreSede)  throws SedeException;
}
