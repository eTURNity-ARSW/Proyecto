package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.SedeException;
import edu.eci.arsw.Eturnity.Persistence.SedePersistence;
import edu.eci.arsw.Eturnity.model.Sede;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MySedePersistence implements SedePersistence {
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
        return null;
    }


    @Override
    public List<Sede> getSedeByCiudad(String ciudad) throws SedeException {
        return null;
    }

    /*@Override
    public boolean Save(Sede s) throws SedeException {
        if(sederep.findByIdentifier(s.getIdentificador())!= null) throw new SedeException(SedeException.ALREDY_EXISTS);
        Sede save = sederep.save(s);
        if(save != null) return true;
        return false;
    }*/
}






