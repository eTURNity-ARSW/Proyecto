package edu.eci.arsw.Eturnity.Persistence.impl;

import edu.eci.arsw.Eturnity.Persistence.TurnoException;
import edu.eci.arsw.Eturnity.Persistence.TurnoPersistence;
import edu.eci.arsw.Eturnity.Repositories.TurnoRepository;
import edu.eci.arsw.Eturnity.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MyTurnPersistence implements TurnoPersistence {
    @Autowired
    private TurnoRepository turnorep;

    @Override
    public boolean guardarTurno(Turno t) throws TurnoException {
        if (turnorep.findByIdentifier(t.getIdentifier()) != null)
            throw new TurnoException(TurnoException.TURNO_REGISTRADO);
        Turno save = turnorep.save(t);
        if (save != null)
            return true;
        return false;

    }

    @Override
    public Turno getTurnoById(String id) throws TurnoException {
        Turno byId = turnorep.findByIdentifier(id);
        if (byId != null) {
            return byId;
        }
        return null;
    }

    @Override
    public List<Turno> getTurnsByUsername(String user) throws TurnoException {
        if (user.equals("Anybody")) {
            return null;
        } else if (user.equals("none")) {
            return null;
        }
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

    @Override
    public boolean updateTurno(Turno t, String id) throws TurnoException {
        return false;
    }

  /*  @Override
    public List<Turno> getAllValidTurnos() throws TurnoException {
        //return turnorep.findByValido();
    }*/

    @Override
    public List<Turno> getTurnosFecha(Date fecha) throws TurnoException {
        return  turnorep.findByFecha(fecha);
    }


}
