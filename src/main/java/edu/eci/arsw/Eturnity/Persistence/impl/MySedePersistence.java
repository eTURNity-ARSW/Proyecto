package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.exceptions.SedeException;
import edu.eci.arsw.Eturnity.model.Sede;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MySedePersistence implements SedePersistence {
    
    @Override
    public List<Sede> getAllSedes() throws SedeException{
        EturnityDB db = new EturnityDB();
        return db.getAllSedes();
    }

    @Override
    public List<Sede> getMySedesByEntidad(String nombreEntidad) throws SedeException {
        EturnityDB db =new EturnityDB();
        return db.getMySedesByEntidad(nombreEntidad);
    }

    @Override
    public List<Sede> getSedesByEntidad(String idEntidad) throws SedeException {
        EturnityDB db = new EturnityDB();
        return db.getAllSedesByEntidad(idEntidad);
    }

    @Override
    public List<Sede> getSedesByEntidadYCiudad(String nombreEntidad, String ciudad) throws SedeException {
        EturnityDB db = new EturnityDB();
        return db.getSedesByEntidadYCiudad(nombreEntidad, ciudad);
    }

    @Override
    public void createSede(Sede sd) throws SedeException {
        EturnityDB db = new EturnityDB();
        db.createSede(sd);
    }

    @Override
    public void deleteSede(String id) throws SedeException {
        EturnityDB db = new EturnityDB();
        db.deleteSede(id);

    }

    @Override
    public Sede getSedeByEntidadNameYSedeName(String nombreEntidad, String ciudad, String nombreSede) throws SedeException{
        EturnityDB db = new EturnityDB();
        return db.getSedeByEntidadNameYSedeName(nombreEntidad, ciudad, nombreSede);
    }

}






