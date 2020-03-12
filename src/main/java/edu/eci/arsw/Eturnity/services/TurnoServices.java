package edu.eci.arsw.Eturnity.services;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoFilter;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eci.arsw.Eturnity.model.Turno;

import java.util.HashSet;
import java.util.Set;

@Service
public class TurnoServices {
    @Autowired
    private TurnoPersistence tp;
    @Autowired
    private TurnoFilter tpf;

    public void agregarNuevoTurno(Turno t){
        try{
            tp.guardarTurno(t);
        }catch(TurnoException ex){
        }
    }

    public Turno getTurno(String id, String username) throws TurnoException{
        return tpf.filtering(tp.getTurno(id,username));
    }

    public Set<Turno> getTotalTurnos() throws TurnoException{
        Set<Turno>filter=new HashSet<>();
        for(Turno t:tp.getTotalTurnos()){
            filter.add(tpf.filtering(t));
        }
        return filter;
    }

    public Set<Turno> getTurnosUsuario(String usuario) throws TurnoException{
        Set<Turno>filter=new HashSet<>();
        for(Turno t:tp.getTurnosUsuario(usuario)){
            filter.add(tpf.filtering(t));
        }
        return filter;
    }


}
