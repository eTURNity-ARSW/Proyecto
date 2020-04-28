package edu.eci.arsw.Eturnity.Persistence;

import edu.eci.arsw.Eturnity.model.Entidad;

import java.util.List;

public interface EntidadPersistence {

    public Entidad getEnterprise(String nombre) throws EntidadException;
    public List<Entidad> getAll();
    public Entidad getEnterpriseByName(String name) throws EntidadException;
    public List<Entidad> getEnterpriseByCity(String city) throws EntidadException;
    public boolean Save(Entidad e) throws EntidadException;
    public void createNewEnterprise(Entidad e);
}
