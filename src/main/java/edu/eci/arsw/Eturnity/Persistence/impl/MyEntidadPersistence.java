package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EntidadException;
import edu.eci.arsw.Eturnity.Persistence.EntidadPersistence;
import edu.eci.arsw.Eturnity.Repositories.EntidadRepository;
import edu.eci.arsw.Eturnity.model.Entidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEntidadPersistence implements EntidadPersistence {
    @Autowired
    private EntidadRepository erepo;

    @Override
    public Entidad getEnterprise(String nit) throws EntidadException {
        List<Entidad> entidad = erepo.findByNit(nit);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad.get(0);
        }
        throw new EntidadException(EntidadException.INVALID_NIT);
    }

    @Override
    public List<Entidad> getAll() {
        return (List<Entidad>) erepo.findAll();
    }

    @Override
    public Entidad getEnterpriseByName(String name) throws EntidadException {
        List<Entidad> entidad = erepo.findByNombre(name);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad.get(0);
        }
        throw new EntidadException(EntidadException.INVALID_NAME);
    }

    @Override
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException {
        List<Entidad> entidad = erepo.findByCiudad(city);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad;
        }
        throw new EntidadException(EntidadException.NO_EXIST_ADDRESS);
    }

    @Override
    public boolean Save(Entidad e) throws EntidadException{
        if(erepo.findByNit(e.getNit())!= null) throw new EntidadException(EntidadException.ALREDY_EXISTS);
        Entidad save = erepo.save(e);
        if(save != null) return true;
        return false;
    }
}
