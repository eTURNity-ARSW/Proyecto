package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.model.Sede;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SedeServices {
    
    @Autowired
    private SedePersistence sp;
    
    public List<Sede> getAllSedes(){
        return sp.getAllSedes();
    }
    
    public List<Sede> getSedesByEntidad(String idEntidad){
        return sp.getSedesByEntidad(idEntidad);
    }
    
    public List<Sede> getSedesByEntidadYCiudad(String idEntidad, String ciudad){
        return sp.getSedesByEntidadYCiudad(idEntidad, ciudad);
    }
    
    public void createSede(Sede sd){
        sp.createSede(sd);
    }

	public void deleteSede(String id) {
        sp.deleteSede(id);
	}
}
