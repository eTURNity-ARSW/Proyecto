package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.exceptions.SedeException;
import edu.eci.arsw.Eturnity.model.Sede;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedeServices {

    @Autowired
    private SedePersistence sp;

    public List<Sede> getAllSedes() throws SedeException {
        return sp.getAllSedes();
    }

    public List<Sede> getMySedesByEntidad (String nombreEntidad) throws SedeException{
        return  sp.getMySedesByEntidad(nombreEntidad);
    }

    public List<Sede> getSedesByEntidad(String idEntidad) throws SedeException{
        return sp.getSedesByEntidad(idEntidad);
    }

    public List<Sede> getSedesByEntidadYCiudad(String nombreEntidad, String ciudad) throws SedeException{
        return sp.getSedesByEntidadYCiudad(nombreEntidad, ciudad);
    }

    public void createSede(Sede sd) throws SedeException{
        sp.createSede(sd);
    }

    public void deleteSede(String id) throws SedeException {
        sp.deleteSede(id);
    }
    
    public Sede getSedeByEntidadNameYSedeName(String nombreEntidad, String ciudad, String nombreSede) throws SedeException{
        return sp.getSedeByEntidadNameYSedeName(nombreEntidad,ciudad, nombreSede);
    }
}
