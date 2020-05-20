package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;
import edu.eci.arsw.Eturnity.Persistence.EturnityDB;
import edu.eci.arsw.Eturnity.exceptions.EntidadException;
import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyEntidadPersistence implements EntidadPersistence {

    @Override
    public Entidad getEnterprise(String nombre)  {
        EturnityDB db = new EturnityDB();
        return db.getEntityByName(nombre);

    }

    @Override
    public List<Entidad> getEnterpriseByCity(String city) {
        return null;
    }

    @Override
    public void createEntidad(Entidad e) {
        EturnityDB db = new EturnityDB();
        db.createEntidad(e);

    }

    @Override
    public void deleteEntidad(String e) {
        EturnityDB db = new EturnityDB();
        db.deleteEntidad(e);

    }

    @Override
    public List<Entidad> getAllEntidades() {
        System.out.println("Entro get all ENTIDADES");
        EturnityDB db=new EturnityDB();
        return db.getAllEntidades();
    }


   
}

