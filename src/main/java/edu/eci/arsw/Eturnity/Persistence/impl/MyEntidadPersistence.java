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
    public Entidad getEnterprise(String nombre) throws EntidadException {
        EturnityDB db = new EturnityDB();
        return db.getEntityByName(nombre);

    }

    @Override
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException {
        return null;
    }

    @Override
    public void createEntidad(Entidad e) throws EntidadException {
        EturnityDB db = new EturnityDB();
        db.createEntidad(e);

    }

    @Override
    public void deleteEntidad(String e) throws EntidadException {
        EturnityDB db = new EturnityDB();
        db.deleteEntidad(e);

    }

    @Override
    public List<Entidad> getAllEntidades() throws EntidadException {
        System.out.println("Entro get all ENTIDADES");
        EturnityDB db=new EturnityDB();
        return db.getAllEntidades();
    }


   
}

