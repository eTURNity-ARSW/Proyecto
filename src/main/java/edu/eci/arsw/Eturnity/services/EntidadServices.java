package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;

import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.exceptions.EntidadException;
import edu.eci.arsw.Eturnity.model.Entidad;
import edu.eci.arsw.Eturnity.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadServices {
    @Autowired
    private EntidadPersistence esp;
    @Autowired
    private TurnoPersistence tsp;


    

    public Entidad getEnterprise(String nombre) throws EntidadException {
        return esp.getEnterprise(nombre);

    }
    public List<Sede> getOfficeByEnterprise(String nit) throws EntidadException {

        esp.getEnterprise(nit).getSedes().forEach(x-> System.out.println(x));
        return esp.getEnterprise(nit).getSedes();

    }


    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException {

        return esp.getEnterpriseByCity(city);

    }

	public List<Entidad> getAllEntidades() throws EntidadException{
        System.out.println("SERVICIOS");
		return esp.getAllEntidades();
	}

	public void createEntidad(Entidad e) throws EntidadException{
        esp.createEntidad(e);
    }
    public void deleteEntidad(String e) throws EntidadException{
        esp.deleteEntidad(e);
    }

    


}
