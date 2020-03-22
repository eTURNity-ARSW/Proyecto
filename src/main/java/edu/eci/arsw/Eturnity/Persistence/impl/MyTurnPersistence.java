package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import edu.eci.arsw.Eturnity.Repositories.UserRepository;
import edu.eci.arsw.Eturnity.model.Sede;
import edu.eci.arsw.Eturnity.model.Turno;
import edu.eci.arsw.Eturnity.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MyTurnPersistence implements TurnoPersistence {
    @Autowired
    private TurnoRepository turnorep;


    @Override
    public boolean guardarTurno(Turno t) throws TurnoException {
        if(turnorep.findByIdentifier(t.getIdentifier())!=null) throw  new TurnoException(TurnoException.TURNO_REGISTRADO);
        Turno save = turnorep.save(t);
        if (save!=null) return true;
        return false;

    }

    @Override
    public Turno getTurnoById(String id) throws TurnoException {
        Turno byId = turnorep.findByIdentifier(id);
        if(byId!=null){
            return byId;
        }
        return null;
    }

    @Override
    public List<Turno> getTurnsByUsername(String user) throws TurnoException {
        return turnorep.findByUser(user);

    }

    @Override
    public List<Turno> getTotalTurnos() throws TurnoException {
        return (List<Turno>) turnorep.findAll();
    }

    @Override
    public List<Turno> getTurnsByOffice(String sede) {
        return turnorep.findBySede(sede);
    }


}
