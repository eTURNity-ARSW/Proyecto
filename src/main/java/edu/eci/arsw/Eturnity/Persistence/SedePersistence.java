package edu.eci.arsw.Eturnity.Persistence;

import java.util.List;

import edu.eci.arsw.Eturnity.model.Sede;

public interface SedePersistence {
    //public Sede getSede(String identificador) throws SedeException;
    public List<Sede> getAll();
    public List<Sede> getSedeByCiudad(String ciudad) throws SedeException;
    /*public boolean Save(Sede s) throws SedeException;
    */
    
    

}

