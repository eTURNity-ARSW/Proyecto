package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.SedeException;
import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.Repositories.SedeRepository;
import edu.eci.arsw.Eturnity.model.Sede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MySedePersistence implements SedePersistence {
    @Autowired
    private SedeRepository sederep;
/*
    @Override 
    public Sede getSede(String identificador) throws SedeException{
        List<Sede> sede = sederep.findByIdentifier(identificador);
        if(!sede.isEmpty()){
            sede.forEach(x -> System.out.println(x));
            return sede.get(0);
        }
        throw new SedeException(SedeException.INVALID_IDENTIFIER);
    }
*/
    @Override
    public List<Sede> getAll(){
        return (List<Sede>) sederep.findAll();
    }
    

    @Override
    public List<Sede> getSedeByCiudad(String ciudad) throws SedeException {
        List<Sede> sede=sederep.findByCiudad(ciudad);
        if (!sede.isEmpty()){
            sede.forEach(x -> System.out.println(x));
            return sede;
        }
        throw new SedeException(SedeException.NO_EXIST_CITY);
    }

    /*@Override
    public boolean Save(Sede s) throws SedeException {
        if(sederep.findByIdentifier(s.getIdentificador())!= null) throw new SedeException(SedeException.ALREDY_EXISTS);
        Sede save = sederep.save(s);
        if(save != null) return true;
        return false;
    }*/
    }

    
    

    


