package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.Persistence.SedeException;
import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.model.Sede;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MySedePersistence implements SedePersistence {
    
    @Override
    public List<Sede> getAllSedes(){
        EturnityDB db = new EturnityDB();
        return db.getAllSedes();
    }

    @Override
    public List<Sede> getSedesByEntidad(String idEntidad) {
        EturnityDB db = new EturnityDB();
        return db.getAllSedesByEntidad(idEntidad);
    }

    @Override
    public List<Sede> getSedesByEntidadYCiudad(String idEntidad, String ciudad) {
        EturnityDB db = new EturnityDB();
        return db.getSedesByEntidadYCiudad(idEntidad, ciudad);
    }

    @Override
    public void createSede(Sede sd) {
        EturnityDB db = new EturnityDB();
        db.createSede(sd);
    }

    @Override
    public void deleteSede(String id) {
        EturnityDB db = new EturnityDB();
        db.deleteSede(id);

    }

}






