package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EntidadException;
import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;
import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MyEntidadPersistence implements EntidadPersistence {

    @Override
    public Entidad getEnterprise(String nit) throws EntidadException {
        return null;
    }

    @Override
    public List<Entidad> getAll() {
        return null;
    }

    @Override
    public Entidad getEnterpriseByName(String name) throws EntidadException {
        return null;
    }

    @Override
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException {
        return null;
    }

    @Override
    public boolean Save(Entidad e) throws EntidadException{
        return false;
    }

    @Override
    public void createNewEnterprise(Entidad e) {
        
    }
}

