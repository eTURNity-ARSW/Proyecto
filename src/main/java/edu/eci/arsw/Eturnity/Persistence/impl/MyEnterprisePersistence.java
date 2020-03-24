package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.EnterpriseException;
import edu.eci.arsw.Eturnity.Persistence.EnterprisePersistence;
import edu.eci.arsw.Eturnity.repositories.EnterpriseRepository;
import edu.eci.arsw.Eturnity.model.Entidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyEnterprisePersistence implements EnterprisePersistence {
    @Autowired
    private EnterpriseRepository erepo;

    @Override
    public Entidad getEnterprise(String nit) throws EnterpriseException {
        List<Entidad> entidad = erepo.findByNit(nit);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad.get(0);
        }
        throw new EnterpriseException(EnterpriseException.INVALID_NIT);
    }

    @Override
    public List<Entidad> getAll() {
        return (List<Entidad>) erepo.findAll();
    }

    @Override
    public Entidad getEnterpriseByName(String name) throws EnterpriseException {
        List<Entidad> entidad = erepo.findByNombre(name);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad.get(0);
        }
        throw new EnterpriseException(EnterpriseException.INVALID_NAME);
    }

    @Override
    public List<Entidad> getEnterpriseByCity(String city) throws EnterpriseException {
        List<Entidad> entidad = erepo.findByCiudad(city);
        if (!entidad.isEmpty()) {
            entidad.forEach(x -> System.out.println(x));
            return entidad;
        }
        throw new EnterpriseException(EnterpriseException.NO_EXIST_ADDRESS);
    }

    @Override
    public boolean Save(Entidad e) throws EnterpriseException{
        if(erepo.findByNit(e.getNit())!= null) throw new EnterpriseException(EnterpriseException.ALREDY_EXISTS);
        Entidad save = erepo.save(e);
        if(save != null) return true;
        return false;
    }
}
