package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;

public interface EnterprisePersistence {

    public Entidad getEnterprise(String nit) throws EnterpriseException;
    public List<Entidad> getAll();
    public Entidad getEnterpriseByName(String name) throws EnterpriseException;
    public List<Entidad> getEnterpriseByCity(String city) throws EnterpriseException;
    public boolean Save(Entidad e) throws EnterpriseException;
}
